package online.nutritabapi.api_nutricional.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public String buscarAlimentoPorNome(String product_name_pt, int page) {
        // Limitar a 10 requisições por minuto
        if (requestCount >= MAX_REQUESTS_PER_MINUTE && (System.currentTimeMillis() - START_TIME) < 60000) {
            throw new RuntimeException("Limite de requisições atingido. Tente novamente em breve.");
        }

        String url = BASE_URL + "?search_terms=product_name_pt&search_simple=1&action=process&json=1&page_size=10&page=" + page;

        // Realizar a requisição
        String resultado = restTemplate.getForObject(url, String.class);

        requestCount++;
        return resultado;
    }
}
