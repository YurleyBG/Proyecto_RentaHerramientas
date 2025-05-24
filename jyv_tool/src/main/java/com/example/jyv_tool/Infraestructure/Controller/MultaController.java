package com.example.jyv_tool.Infraestructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jyv_tool.Application.Service.MultaService;
import com.example.jyv_tool.Domain.Dto.Multa.MultaRequest;
import com.example.jyv_tool.Domain.Dto.Multa.ResponseMulta;
import com.example.jyv_tool.Domain.Entity.Multas;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value="/Api" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class MultaController {

    
    private final MultaService multaService;

    public MultaController( @Lazy MultaService multaService) {
        this.multaService = multaService;
    }

    @GetMapping("/multa")
    public List<Multas> findAll() {
        List<Multas> MultaResult= multaService.findAllMulta();
        return MultaResult;
    }

    @PostMapping("/multa")
    public ResponseEntity<ResponseMulta> createNewMulta(@RequestBody MultaRequest newMulta) {
        return new ResponseEntity<>(
            multaService.createNewMulta(newMulta),
            HttpStatus.valueOf(200)
        );
    }

    @PatchMapping("/multa/{id}")
    public ResponseEntity<ResponseMulta> UpdateMulta(@PathVariable Long id,@RequestBody MultaRequest Multa ){
        return ResponseEntity.ok().body(multaService.UpdateMulta(id,Multa));
    }

}
