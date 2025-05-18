package com.example.jyv_tool.Infraestructure.Controller;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jyv_tool.Application.Service.FacturaService;
import com.example.jyv_tool.Domain.Entity.Factura;

@RestController
@RequestMapping(value="/Home" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class FacturaController {

    
    private final FacturaService facturaService;

    public FacturaController(@Lazy FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping("/factura")
    public List<Factura> findAll() {
        List<Factura> facturaResult= facturaService.findAllFactura();
        return facturaResult;
    }
    @DeleteMapping("/factura/{id}")
    public ResponseEntity<?> DeleteFactura(@PathVariable Long id){

        boolean deletefacture= facturaService.deleteFactura(id);
        if (deletefacture) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }

}
