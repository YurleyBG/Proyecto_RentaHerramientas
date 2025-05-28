package com.example.jyv_tool.Infraestructure.Controller;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jyv_tool.Application.Service.HerramientaService;
import com.example.jyv_tool.Domain.Dto.Herramienta.HerramientaRequest;
import com.example.jyv_tool.Domain.Dto.Herramienta.ResponseHerramientas;
import com.example.jyv_tool.Domain.Entity.Herramienta;

@RestController
@RequestMapping(value="/Api" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class HerramientaController {

    private final HerramientaService herramientaService;

    public HerramientaController(@Lazy HerramientaService herramientaService) {
        this.herramientaService = herramientaService;
    }

    @GetMapping("/herramienta")
    public List<Herramienta> findAll( @RequestParam(required = false) String search , @RequestParam(required = false) String category,@RequestParam(required = false) Boolean available) {

        if (available != null && available) { 
            return herramientaService.findHerramientasDisponibles();
        }
        if (search != null && !search.isEmpty() && category != null && !category.isEmpty() && !category.equalsIgnoreCase("Todas")) {
            
            return herramientaService.searchHerramientas(search);
        } 
        else if (search != null && !search.isEmpty()) {
            return herramientaService.searchHerramientas(search);
        } 
        else if (category != null && !category.isEmpty() && !category.equalsIgnoreCase("Todas")) {
            return herramientaService.findHerramientasByCategoria(category);
        } 
        else {
            return herramientaService.findAllHerramienta();
        }
      
    }
    @DeleteMapping("/herramienta/{id}")
    public ResponseEntity<Herramienta> findHerramientaById(@PathVariable Long id) {
        Herramienta herramienta = herramientaService.findHerramientaById(id); 
        if (herramienta != null) {
            return ResponseEntity.ok(herramienta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/herramienta/{id}")
    public ResponseEntity<ResponseHerramientas> UpdateHerramienta (@PathVariable Long id, @RequestBody HerramientaRequest herramienta ){
        return ResponseEntity.ok().body(herramientaService.UpdateHerramienta(id, herramienta));
    }

    @PostMapping("/herramienta")
    public ResponseEntity<ResponseHerramientas> createNewHerramienta(@RequestBody HerramientaRequest newHerramienta) {
        return new ResponseEntity<>(
                herramientaService.createNewHerramienta(newHerramienta),
                HttpStatus.valueOf(200)
        );
    }
}
