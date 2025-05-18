package com.example.jyv_tool.Infraestructure.RepositoryImpl.Multa;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.jyv_tool.Application.Service.MultaService;
import com.example.jyv_tool.Domain.Dto.Multa.MultaRequest;
import com.example.jyv_tool.Domain.Dto.Multa.ResponseMulta;
import com.example.jyv_tool.Domain.Entity.Multas;
import com.example.jyv_tool.Infraestructure.Repository.Multa.MultaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MultaRepositoryImpl implements MultaService {

   
    private final MultaRepository multaRepository;

    public MultaRepositoryImpl(@Lazy MultaRepository multaRepository) {
        this.multaRepository = multaRepository;
    }

    @Override
    public List<Multas> findAllMulta() {
        return multaRepository.findAll();
    }

    @Override
    public ResponseMulta createNewMulta(MultaRequest newMulta) {
        Multas multa = new Multas();
        multa.setDescripcion(newMulta.getDescripcion());
        multa.setCosto(newMulta.getCosto());
        multa.setFecha(newMulta.getFecha());

        Multas savedMulta = multaRepository.save(multa);

        ResponseMulta response = new ResponseMulta();
        response.setDescripcion(savedMulta.getDescripcion());
        response.setCosto(savedMulta.getCosto());
        response.setFecha(savedMulta.getFecha());

        return response;
    }

    @Override
    public ResponseMulta UpdateMulta(Long id, MultaRequest multaReq) {
        Multas multa = multaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la multa con la id solicitada"));

        if (multaReq.getDescripcion() != null) {
            multa.setDescripcion(multaReq.getDescripcion());
        }
        if (multaReq.getCosto() != null) {
            multa.setCosto(multaReq.getCosto());
        }
        if (multaReq.getFecha() != null) {
            multa.setFecha(multaReq.getFecha());
        }

        multaRepository.save(multa);

        ResponseMulta response = new ResponseMulta();
        response.setDescripcion(multa.getDescripcion());
        response.setCosto(multa.getCosto());
        response.setFecha(multa.getFecha());

        return response;
    }
}
