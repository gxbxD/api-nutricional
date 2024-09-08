package online.nutritabapi.api_nutricional.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import online.nutritabapi.api_nutricional.model.Alimento;
import online.nutritabapi.api_nutricional.repository.AlimentoRepository;

@Service
public class AlimentoService {
    private final RestTemplate restTemplate;
    private final String BASE_URL = "https://world.openfoodfacts.net/api/v2/search";
    private final int MAX_REQUESTS_PER_MINUTE = 10;
    private int requestCount = 0;
    private final long START_TIME = System.currentTimeMillis();

    public AlimentoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private AlimentoRepository alimentoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Alimento> pesquisarAlimentos(String nome) {
        // Verificação adicional para garantir que o repositório não é nulo
        if (alimentoRepository == null) {
            throw new IllegalStateException("O repositório não foi injetado corretamente.");
        }

        // Busca no banco de dados
        List<Alimento> alimentos = alimentoRepository.findByNomeContainingIgnoreCase(nome);

        // Se encontrar alimentos no banco, retorna
        if (!alimentos.isEmpty()) {
            return alimentos;
        }

        // Caso contrário, buscar na API externa
        try {
            Alimento novoAlimento = buscarAlimentoPorNome(nome, 1); // Busca o alimento na API externa
            if (novoAlimento != null) {
                // Salva o novo alimento no banco de dados
                alimentoRepository.save(novoAlimento);
                // Retorna o alimento como uma lista
                return List.of(novoAlimento);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar alimento: " + e.getMessage(), e);
        }

        // Retorna lista vazia se nada foi encontrado
        return List.of();
    }

    // Método para buscar o alimento pela API externa e transformar no objeto Alimento
    private Alimento buscarAlimentoPorNome(String product_name_pt, int page) {
        // URL da requisição com os parâmetros corretos
        String url = "https://world.openfoodfacts.org/cgi/search.pl?search_terms=" + product_name_pt 
            + "&search_simple=1&action=process&json=1&page_size=10&page=" + page;

        // Realizar a requisição
        String resultado = restTemplate.getForObject(url, String.class);

        try {
            // Converter o resultado JSON para Map
            Map<String, Object> dadosApi = objectMapper.readValue(resultado, HashMap.class);

            // Verificar se há produtos na resposta
            if (dadosApi.containsKey("products") && !((List<?>) dadosApi.get("products")).isEmpty()) {
                // Pegar o primeiro produto da lista (ou iterar para mais)
                Map<String, Object> produto = ((List<Map<String, Object>>) dadosApi.get("products")).get(0);

                // Transformar o produto em objeto Alimento
                return transformarDadosParaAlimento(produto);
            } else {
                throw new RuntimeException("Nenhum alimento encontrado com o nome: " + product_name_pt);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar dados da API: " + e.getMessage(), e);
        }
    }

    // Função que transforma os dados da API externa no modelo Alimento
    private Alimento transformarDadosParaAlimento(Map<String, Object> produto) {
        Map<String, Object> nutrimentos = (Map<String, Object>) produto.get("nutriments");

        Alimento alimento = new Alimento();
        alimento.setNome((String) produto.get("product_name"));
        alimento.setDescricao((String) produto.get("ingredients_text"));
        alimento.setTipo((String) produto.get("categories"));

        // Mapeamento dos campos nutricionais
        alimento.setCalorias(getDoubleValue(nutrimentos, "energy-kcal_100g"));
        alimento.setCarboidratos(getDoubleValue(nutrimentos, "carbohydrates_100g"));
        alimento.setProteina(getDoubleValue(nutrimentos, "proteins_100g"));
        alimento.setGord_total(getDoubleValue(nutrimentos, "fat_100g"));
        alimento.setFibras(getDoubleValue(nutrimentos, "fiber_100g"));
        alimento.setSodio(getDoubleValue(nutrimentos, "sodium_100g"));

        // Continue mapeando os outros campos necessários...

        return alimento;
    }

    // Função utilitária para pegar valores do mapa como Double
    private Double getDoubleValue(Map<String, Object> map, String key) {
        Object value = map.get(key);
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        return 0.0;
    }
}
