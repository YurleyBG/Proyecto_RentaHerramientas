package com.example.jyv_tool.Infraestructure.RepositoryImpl.Inventario;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.jyv_tool.Application.Service.InventarioService;
import com.example.jyv_tool.Domain.Dto.Inventario.InventarioRequest;
import com.example.jyv_tool.Domain.Dto.Inventario.ResponseInventario;
import com.example.jyv_tool.Domain.Entity.Inventario;
import com.example.jyv_tool.Infraestructure.Repository.Inventario.InventarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InventarioRepositoryImpl implements  InventarioService{


    private final InventarioRepository inventarioRepository;

    public InventarioRepositoryImpl( @Lazy InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    @Override
    public List<Inventario> findAllInventario() {
        return inventarioRepository.findAll();
    }


    @Override
    public ResponseInventario UpdateInventario(Long id, InventarioRequest inventarioReq) {
        Inventario inventario = inventarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró el inventario con la id solicitada"));

        if (inventarioReq.getFecha() != null) {
            inventario.setFecha(inventarioReq.getFecha());
        }
        if (inventarioReq.getStock() >= 0) { 
            inventario.setStock(inventarioReq.getStock());
        }

        inventarioRepository.save(inventario);

        ResponseInventario response = new ResponseInventario();
        response.setFecha(inventario.getFecha());
        response.setStock(inventario.getStock());

        return response;
    }

}
