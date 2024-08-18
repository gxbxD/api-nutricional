package online.nutritabapi.api_nutricional.controller;

import online.nutritabapi.api_nutricional.model.Alimento;
import online.nutritabapi.api_nutricional.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alimentos")
public class AlimentoController {
    
    @Autowired
    private AlimentoService alimentoService;

    @PostMapping
    public ResponseEntity<Alimento> adicionarAlimento(@RequestBody Alimento alimento) {
        Alimento novoAlimento = alimentoService.salvarAlimento(alimento);
        return new ResponseEntity<>(novoAlimento, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Alimento>> listarAlimentos() {
        List<Alimento> alimentos = alimentoService.listarAlimentos();
        return new ResponseEntity<>(alimentos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alimento> obterAlimentoPorId(@PathVariable Long id) {
        Alimento alimento = alimentoService.buscarPorId(id);
        if (alimento != null) {
            return new ResponseEntity<>(alimento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
