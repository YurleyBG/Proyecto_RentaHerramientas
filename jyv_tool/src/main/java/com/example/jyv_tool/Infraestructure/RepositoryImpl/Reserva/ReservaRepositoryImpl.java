package com.example.jyv_tool.Infraestructure.RepositoryImpl.Reserva;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.jyv_tool.Application.Service.ReservaService;
import com.example.jyv_tool.Domain.Dto.Reserva.ReserveRequest;
import com.example.jyv_tool.Domain.Dto.Reserva.ResponseReserve;
import com.example.jyv_tool.Domain.Entity.Estado;
import com.example.jyv_tool.Domain.Entity.Herramienta;
import com.example.jyv_tool.Domain.Entity.Reserva;
import com.example.jyv_tool.Domain.Entity.Usuario;
import com.example.jyv_tool.Infraestructure.Repository.Estado.EstadoRepository;
import com.example.jyv_tool.Infraestructure.Repository.Herramienta.HerramientaRepository;
import com.example.jyv_tool.Infraestructure.Repository.Reserva.RepositoryReserva;
import com.example.jyv_tool.Infraestructure.Repository.Usuario.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ReservaRepositoryImpl implements ReservaService {

    
    private final RepositoryReserva repositoryreserva;
    private final UsuarioRepository usuarioRepository; 
    private final EstadoRepository estadoRepository;  
    private final HerramientaRepository herramientaRepository; 

    public ReservaRepositoryImpl(@Lazy RepositoryReserva repositoryreserva, @Lazy UsuarioRepository usuarioRepository,
        @Lazy EstadoRepository estadoRepository, @Lazy HerramientaRepository herramientaRepository) {
        this.repositoryreserva = repositoryreserva;
        this.usuarioRepository = usuarioRepository;
        this.estadoRepository = estadoRepository;
        this.herramientaRepository = herramientaRepository;
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
        Reserva reservita = new Reserva();
        reservita.setCantidad(newReserve.getCantidad());
        reservita.setCosto_total(newReserve.getCosto_total());
        reservita.setFecha_fin(newReserve.getFecha_fin());
        reservita.setFecha_inicio(newReserve.getFecha_inicio());

        Usuario usuario = usuarioRepository.findByUsername(newReserve.getNombreCliente()) 
        .orElseThrow(() -> new EntityNotFoundException("No se encontro "));
        reservita.setUsers(usuario);

        Estado estado = estadoRepository.findByNombre(newReserve.getNombreEstado())
        .orElseThrow(() -> new EntityNotFoundException("no se encontro "));
        reservita.setEstados(estado);

        Herramienta herramienta = herramientaRepository.findByNombre(newReserve.getNombreHerramienta())
        .orElseThrow(() -> new EntityNotFoundException("no se encontro" ));
        reservita.setHerramienta(herramienta);

        Reserva reservaSave = repositoryreserva.save(reservita);

        ResponseReserve reserresp = new ResponseReserve();
        reserresp.setId(reservaSave.getId());
        reserresp.setCantidad(reservaSave.getCantidad());
        reserresp.setCosto_total(reservaSave.getCosto_total());
        reserresp.setFecha_fin(reservaSave.getFecha_fin());
        reserresp.setFecha_inicio(reservaSave.getFecha_inicio());

        if (reservaSave.getUsers() != null) {
            reserresp.setNombreCliente(reservaSave.getUsers().getNombre1()); 
        }
        if (reservaSave.getEstados() != null) {
            reserresp.setNombreEstado(reservaSave.getEstados().getNombre());
        }
        if (reservaSave.getHerramienta() != null) {
            reserresp.setNombreHerramienta(reservaSave.getHerramienta().getNombre());
        }

        return reserresp;
    }

    @Override
    public ResponseReserve UpdateReserve(Long id, ReserveRequest Reserve) {
        Reserva reser= repositoryreserva.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No se encontroLa reserva"));

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
