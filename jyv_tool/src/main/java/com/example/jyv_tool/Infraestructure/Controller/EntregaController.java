package com.example.jyv_tool.Infraestructure.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jyv_tool.Application.Service.EntregaService;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.jyv_tool.Domain.Dto.Entrega.EntregaRequest;
import com.example.jyv_tool.Domain.Dto.Entrega.ResponseEntrega;
import com.example.jyv_tool.Domain.Entity.Entrega;

@RestController
@RequestMapping(value="/Api" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class EntregaController {

    
    private final EntregaService entregaService;

    public EntregaController(@Lazy EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @GetMapping("/entrega")
    public List<Entrega> findAll() {
        List<Entrega> EntregaResult= entregaService.findAllEntrega();
        return EntregaResult;
    }
    @PatchMapping("/entrega/{id}")
    public ResponseEntity<ResponseEntrega> UpdateEntrega (@PathVariable Long id,@RequestBody EntregaRequest Entrega ){
        return ResponseEntity.ok().body(entregaService.UpdateEntrega(id,Entrega));
    }
    @PostMapping("/entrega")
    public ResponseEntity<ResponseEntrega> createNewEntrega(@RequestBody EntregaRequest newEntrega) {
        return new ResponseEntity<>(
            entregaService.createNewEntrega(newEntrega),
            HttpStatus.valueOf(200)
        );
    }

}
