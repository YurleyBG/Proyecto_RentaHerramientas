package com.example.jyv_tool.Infraestructure.RepositoryImpl.Pago;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.jyv_tool.Application.Service.PagoService;
import com.example.jyv_tool.Domain.Dto.Pago.PagoRequest;
import com.example.jyv_tool.Domain.Dto.Pago.ResponsePago;
import com.example.jyv_tool.Domain.Entity.Pago;
import com.example.jyv_tool.Infraestructure.Repository.Pago.PagoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PagoRepositoryImpl  implements  PagoService{

   
    private final PagoRepository pagoRepository;

    public PagoRepositoryImpl(@Lazy PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public List<Pago> findAllPago() {
        return pagoRepository.findAll();
    }

    @Override
    public ResponsePago createNewpago(PagoRequest newpago) {
        Pago pago = new Pago();
        pago.setMonto(newpago.getMonto());
        pago.setFecha(newpago.getFecha());

        Pago saved = pagoRepository.save(pago);

        ResponsePago response = new ResponsePago();
        response.setMonto(saved.getMonto());
        response.setFecha(saved.getFecha());

        return response;
    }

    @Override
    public ResponsePago Updatepago(Long id, PagoRequest req) {
        Pago pago = pagoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("No se encontró el pago con la id solicitada"));

        if (req.getMonto() != null) {
            pago.setMonto(req.getMonto());
        }
        if (req.getFecha() != null) {
            pago.setFecha(req.getFecha());
        }

        pagoRepository.save(pago);

        ResponsePago response = new ResponsePago();
        response.setMonto(pago.getMonto());
        response.setFecha(pago.getFecha());

        return response;
    }

}
