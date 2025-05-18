package com.example.jyv_tool.Infraestructure.RepositoryImpl.Alquiler;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.jyv_tool.Application.Service.AlquilerService;
import com.example.jyv_tool.Domain.Dto.Alquiler.AlquilerRequest;
import com.example.jyv_tool.Domain.Dto.Alquiler.ResponseAlquilar;
import com.example.jyv_tool.Domain.Entity.Alquiler;
import com.example.jyv_tool.Infraestructure.Repository.Alquiler.AlquilerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlqulerRepositryImpl implements  AlquilerService{

    private final AlquilerRepository alquilerRepository;

    public AlqulerRepositryImpl(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }

    @Override
    public List<Alquiler> findAllAlquiler() {
        return alquilerRepository.findAll();
    }

    @Override
    public boolean deleteAlquiler(Long id) {
        Optional<Alquiler> alquiler = alquilerRepository.findById(id);
        if (alquiler.isPresent()) {
            alquilerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ResponseAlquilar createNewAlquiler(AlquilerRequest newAlquiler) {
        Alquiler alquiler = new Alquiler();
        alquiler.setFecha_alquiler(newAlquiler.getFecha_alquiler());
        alquiler.setFecha_esperando(newAlquiler.getFecha_esperando());
        alquiler.setFecha_entrega(newAlquiler.getFecha_entrega());
        alquiler.setEstado(newAlquiler.getEstado());

        Alquiler saved = alquilerRepository.save(alquiler);

        ResponseAlquilar response = new ResponseAlquilar();
        response.setFecha_alquiler(saved.getFecha_alquiler());
        response.setFecha_esperando(saved.getFecha_esperando());
        response.setFecha_entrega(saved.getFecha_entrega());
        response.setEstado(saved.getEstado());

        return response;
    }

    @Override
    public ResponseAlquilar UpdateAlquiler(Long id, AlquilerRequest req) {
        Alquiler alquiler = alquilerRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("No se encontró el alquiler con la id solicitada"));

        if (req.getFecha_alquiler() != null) {
            alquiler.setFecha_alquiler(req.getFecha_alquiler());
        }
        if (req.getFecha_esperando() != null) {
            alquiler.setFecha_esperando(req.getFecha_esperando());
        }
        if (req.getFecha_entrega() != null) {
            alquiler.setFecha_entrega(req.getFecha_entrega());
        }
        if (req.getEstado() != null) {
            alquiler.setEstado(req.getEstado());
        }

        alquilerRepository.save(alquiler);

        ResponseAlquilar response = new ResponseAlquilar();
        response.setFecha_alquiler(alquiler.getFecha_alquiler());
        response.setFecha_esperando(alquiler.getFecha_esperando());
        response.setFecha_entrega(alquiler.getFecha_entrega());
        response.setEstado(alquiler.getEstado());

        return response;
    }
    

}
