package com.example.jyv_tool.Infraestructure.RepositoryImpl.Entrega;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jyv_tool.Application.Service.EntregaService;
import com.example.jyv_tool.Domain.Dto.Entrega.EntregaRequest;
import com.example.jyv_tool.Domain.Dto.Entrega.ResponseEntrega;
import com.example.jyv_tool.Domain.Entity.Entrega;
import com.example.jyv_tool.Infraestructure.Repository.Enttega.EntregaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EntregarRepositoryImpl implements EntregaService {

    private final EntregaRepository entregaRepository;

    public EntregarRepositoryImpl(EntregaRepository entregaRepository) {
        this.entregaRepository = entregaRepository;
    }

    @Override
    public List<Entrega> findAllEntrega() {
        return entregaRepository.findAll();
    }

    @Override
    public ResponseEntrega createNewEntrega(EntregaRequest newEntrega) {
        Entrega entrega = new Entrega();
        entrega.setEstado(newEntrega.getEstado());
        entrega.setDireccion_entrega(newEntrega.getDireccion_entrega());
        entrega.setCosto(newEntrega.getCosto());
        entrega.setFecha(newEntrega.getFecha());

        Entrega savedEntrega = entregaRepository.save(entrega);

        ResponseEntrega response = new ResponseEntrega();
        response.setEstado(savedEntrega.getEstado());
        response.setDireccion_entrega(savedEntrega.getDireccion_entrega());
        response.setCosto(savedEntrega.getCosto());
        response.setFecha(savedEntrega.getFecha());

        return response;
    }

    @Override
    public ResponseEntrega UpdateEntrega(Long id, EntregaRequest entregaReq) {
        Entrega entrega = entregaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la entrega con ID: " + id));

        if (entregaReq.getEstado() != null) {
            entrega.setEstado(entregaReq.getEstado());
        }
        if (entregaReq.getDireccion_entrega() != null) {
            entrega.setDireccion_entrega(entregaReq.getDireccion_entrega());
        }
        if (entregaReq.getCosto() != null) {
            entrega.setCosto(entregaReq.getCosto());
        }
        if (entregaReq.getFecha() != null) {
            entrega.setFecha(entregaReq.getFecha());
        }

        entregaRepository.save(entrega);

        ResponseEntrega response = new ResponseEntrega();
        response.setEstado(entrega.getEstado());
        response.setDireccion_entrega(entrega.getDireccion_entrega());
        response.setCosto(entrega.getCosto());
        response.setFecha(entrega.getFecha());

        return response;
    }

}
