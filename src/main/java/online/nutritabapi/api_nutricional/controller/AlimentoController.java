package online.nutritabapi.api_nutricional.controller;

import online.nutritabapi.api_nutricional.exceptions.AlimentoNotFoundException;
import online.nutritabapi.api_nutricional.model.Alimento;
import online.nutritabapi.api_nutricional.service.AlimentoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/alimentos")
@RestController
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping("")
public ResponseEntity<List<Alimento>> pesquisarAlimentos(@RequestParam String nome) {
    if (nome == null || nome.isEmpty()) {
        return ResponseEntity.badRequest().body(null);
    }

    List<Alimento> alimentos = alimentoService.pesquisarAlimentos(nome);

    // Lança a exceção personalizada quando a lista está vazia
    if (alimentos.isEmpty()) {
        throw new AlimentoNotFoundException("Nenhum alimento encontrado com o nome: " + nome);
    }

    return ResponseEntity.ok(alimentos);
}

    

   @ExceptionHandler(AlimentoNotFoundException.class)
public ResponseEntity<String> handleAlimentoNotFoundException(AlimentoNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
}

@ExceptionHandler(Exception.class)
public ResponseEntity<String> handleGenericException(Exception ex) {
    ex.printStackTrace();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: " + ex.getMessage());
}

}
