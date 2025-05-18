package com.example.jyv_tool.Infraestructure.RepositoryImpl.Reserva;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.jyv_tool.Application.Service.ReservaService;
import com.example.jyv_tool.Domain.Dto.ReserveRequest;
import com.example.jyv_tool.Domain.Dto.ResponseReserve;
import com.example.jyv_tool.Domain.Entity.Reserva;
import com.example.jyv_tool.Infraestructure.Repository.Reserva.RepositoryReserva;
import com.example.jyv_tool.Infraestructure.util.Exception.UsuariosDuplicationException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservaRepositoryImpl implements ReservaService{

    private final RepositoryReserva repositoryreserva;

    public ReservaRepositoryImpl(RepositoryReserva repositoryreserva) {
        this.repositoryreserva = repositoryreserva;
    }

    @Override
    public List<Reserva> findAllReserve() {
        return repositoryreserva.findAll();
    
    }

    @Override
    public boolean deleteReserve(Long id) {
        Optional<Reserva> reserveRemove =repositoryreserva.findById(id);
        if (reserveRemove.isPresent()) {
            repositoryreserva.deleteById(id);
            return true;
        } 
        return false;
    }

    @Override
    public ResponseReserve createNewReserve(ReserveRequest newReserve) {
        Optional<Reserva> reserva = repositoryreserva.findByid(newReserve.getId());
        if (reserva.isPresent()){
            throw new UsuariosDuplicationException("La Reserva ya se encuentra registrado", HttpStatus.CONFLICT);
        }
        Reserva reservita = new Reserva();
        reservita.setCantidad(newReserve.getCantidad());
        reservita.setCosto_total(newReserve.getCosto_total());
        reservita.setFecha_fin(newReserve.getFecha_fin());
        reservita.setFecha_inicio(newReserve.getFecha_inicio());
  


        Reserva reservaSave = repositoryreserva.save(reservita);
        ResponseReserve reserresp = new ResponseReserve();
        reserresp.setCantidad(reservaSave.getCantidad());
        reserresp.setCosto_total(reservaSave.getCosto_total());
        reserresp.setFecha_fin(reservaSave.getFecha_fin());
        reserresp.setFecha_inicio(reservaSave.getFecha_inicio());

        return reserresp;
    }

    @Override
    public ResponseReserve UpdateReserve(Long id, ReserveRequest Reserve) {
        Reserva reser= repositoryreserva.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No se encontroLa reserva con la id solicitada"));

        if(Reserve.getCosto_total()!=null){
            reser.setCosto_total(Reserve.getCosto_total());
        }
        if(Reserve.getFecha_fin()!=null){
            reser.setFecha_fin(Reserve.getFecha_fin());
        }
        if(Reserve.getFecha_inicio()!=null){
            reser.setFecha_inicio(Reserve.getFecha_inicio());
        }
       

        repositoryreserva.save(reser);
        ResponseReserve resp = new ResponseReserve();
        resp.setCantidad(reser.getCantidad());
        resp.setCosto_total(reser.getCosto_total());
        resp.setFecha_fin(reser.getFecha_fin());
        resp.setFecha_inicio(reser.getFecha_inicio());
        return resp;
    }

}
