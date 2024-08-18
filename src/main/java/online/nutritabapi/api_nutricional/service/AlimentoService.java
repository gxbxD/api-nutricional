package online.nutritabapi.api_nutricional.service;

import online.nutritabapi.api_nutricional.model.Alimento;
import online.nutritabapi.api_nutricional.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlimentoService {
    @Autowired
    private AlimentoRepository alimentoRepository;

    public Alimento salvarAlimento(Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    public List<Alimento> listarAlimentos() {
        return alimentoRepository.findAll();
    }
    public Alimento buscarPorId(Long id) {
        return alimentoRepository.findById(id).orElse(null);
    }
}
