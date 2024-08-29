package online.nutritabapi.api_nutricional.controller;

import online.nutritabapi.api_nutricional.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping("/alimentos")
    public String buscarAlimentos(@RequestParam String product_name_pt, @RequestParam(defaultValue = "1") int page) {
        return alimentoService.buscarAlimentoPorNome(product_name_pt, page);
    }
}
