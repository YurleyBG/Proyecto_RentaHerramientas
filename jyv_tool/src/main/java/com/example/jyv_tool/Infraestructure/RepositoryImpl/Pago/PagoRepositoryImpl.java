package com.example.jyv_tool.Infraestructure.RepositoryImpl.Pago;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.jyv_tool.Application.Service.PagoService;
import com.example.jyv_tool.Domain.Dto.Pago.PagoRequest;
import com.example.jyv_tool.Domain.Dto.Pago.ResponsePago;
import com.example.jyv_tool.Domain.Entity.FormaPago;
import com.example.jyv_tool.Domain.Entity.Pago;
import com.example.jyv_tool.Domain.Entity.Reserva;
import com.example.jyv_tool.Infraestructure.Repository.FormaPago.FormaPagoRepository;
import com.example.jyv_tool.Infraestructure.Repository.Pago.PagoRepository;
import com.example.jyv_tool.Infraestructure.Repository.Reserva.RepositoryReserva;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PagoRepositoryImpl  implements  PagoService{

   
    private final PagoRepository pagoRepository;
    private final RepositoryReserva repositoryReserva;
    private final FormaPagoRepository formaPagoRepository;

    public PagoRepositoryImpl(@Lazy PagoRepository pagoRepository,@Lazy RepositoryReserva repositoryReserva,@Lazy FormaPagoRepository formaPagoRepository) {
        this.pagoRepository = pagoRepository;
        this.repositoryReserva=repositoryReserva;
        this.formaPagoRepository=formaPagoRepository;
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
        if (newpago.getIdReserva() != null) {
            Reserva reserva = repositoryReserva.findById(newpago.getIdReserva())
            .orElseThrow(() -> new EntityNotFoundException("No se encontro " ));
            pago.setReserva(reserva);
        } 

        if (newpago.getFormaPago() != null && !newpago.getFormaPago().trim().isEmpty()) {
            Optional<FormaPago> optionalFormaPago = formaPagoRepository.findByMetodopago(newpago.getFormaPago());
            if (optionalFormaPago.isPresent()) {
                pago.setFormaPago(optionalFormaPago.get());
            }
        } 
        Pago saved = pagoRepository.save(pago);

        ResponsePago response = new ResponsePago();
        response.setId(saved.getId());
        response.setMonto(saved.getMonto());
        response.setFecha(saved.getFecha());
        response.setFormaPago(saved.getFormaPago().getMetodopago()); 
        response.setIdReserva(saved.getReserva().getId()); 

        return response;
    }

    @Override
    public ResponsePago Updatepago(Long id, PagoRequest requerido) {
        Pago pago = pagoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("No se encontró "));

        if (requerido.getMonto() != null) {
            pago.setMonto(requerido.getMonto());
        }
        if (requerido.getFecha() != null) {
            pago.setFecha(requerido.getFecha());
        }

        pagoRepository.save(pago);

        ResponsePago response = new ResponsePago();
        response.setMonto(pago.getMonto());
        response.setFecha(pago.getFecha());

        return response;
    }

}
