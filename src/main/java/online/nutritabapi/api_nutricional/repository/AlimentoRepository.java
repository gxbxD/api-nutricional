package online.nutritabapi.api_nutricional.repository;

import online.nutritabapi.api_nutricional.model.Alimento;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    List<Alimento> findByNomeContainingIgnoreCase(String nome);
} 
