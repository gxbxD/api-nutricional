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

@RequestMapping("/api/alimentos")
@RestController
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping("")
    public String buscarAlimentos(@RequestParam String product_name_pt, @RequestParam(defaultValue = "1") int page) {
        return alimentoService.buscarAlimentoPorNome(product_name_pt, page);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<Alimento>> pesquisarAlimentos(@RequestParam String nome) {
        List<Alimento> alimentos = alimentoService.pesquisarAlimentos(nome);
        return ResponseEntity.ok(alimentos);
    }

    @ExceptionHandler(AlimentoNotFoundException.class)
    public ResponseEntity<String> handleAlimentoNotFoundException(AlimentoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    
}
