package com.example.jyv_tool.Infraestructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jyv_tool.Application.Service.InventarioService;
import com.example.jyv_tool.Domain.Dto.Inventario.InventarioRequest;
import com.example.jyv_tool.Domain.Dto.Inventario.ResponseInventario;
import com.example.jyv_tool.Domain.Entity.Inventario;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value="/Home" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class InventarioController {

    
    private final InventarioService inventarioService;

    public InventarioController(@Lazy InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping("/inventario")
    public List<Inventario> findAll() {
        List<Inventario> InventarioResult= inventarioService.findAllInventario();
        return InventarioResult;
    }
    @PatchMapping("/inventario/{id}")
    public ResponseEntity<ResponseInventario> UpdateInventario (@PathVariable Long id,@RequestBody InventarioRequest Inventario ){
        return ResponseEntity.ok().body(inventarioService.UpdateInventario(id,Inventario));
    }
    @PostMapping("/inventario")
    public ResponseEntity<ResponseInventario> createNewInventario(@RequestBody InventarioRequest newInventario) {
        return new ResponseEntity<>(
            inventarioService.createNewInventario(newInventario),
            HttpStatus.valueOf(200)
        );
    }
}
