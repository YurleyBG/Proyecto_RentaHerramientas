package com.example.jyv_tool.Infraestructure.RepositoryImpl.Devoluciones;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.jyv_tool.Application.Service.DevolucionesService;
import com.example.jyv_tool.Domain.Dto.Devoluciones.DevolucionesRequest;
import com.example.jyv_tool.Domain.Dto.Devoluciones.ResponseDevoluciones;
import com.example.jyv_tool.Domain.Entity.Devoluciones;
import com.example.jyv_tool.Domain.Entity.Estado;
import com.example.jyv_tool.Domain.Entity.Alquiler;
import com.example.jyv_tool.Infraestructure.Repository.Alquiler.AlquilerRepository;
import com.example.jyv_tool.Infraestructure.Repository.Devoluciones.DevolucionesRepository;
import com.example.jyv_tool.Infraestructure.Repository.Estado.EstadoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DevolucionesRepositoryImpl implements  DevolucionesService {

    private final DevolucionesRepository devolucionesRepository;
    private final EstadoRepository estadoRepository; 
    private final AlquilerRepository alquilerRepository; 

    public DevolucionesRepositoryImpl(@Lazy DevolucionesRepository devolucionesRepository,@Lazy EstadoRepository estadoRepository, 
    @Lazy AlquilerRepository alquilerRepository) 
    {
        this.devolucionesRepository = devolucionesRepository;
        this.estadoRepository = estadoRepository;
        this.alquilerRepository = alquilerRepository;
    }
    @Override
    public List<Devoluciones> findAllDevoluciones() {
        return devolucionesRepository.findAll();
    }

    @Override
    public boolean deleteDevoluciones(Long id) {
        Optional<Devoluciones> devolucion = devolucionesRepository.findById(id);
        if (devolucion.isPresent()) {
            devolucionesRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ResponseDevoluciones createNewDevoluciones(DevolucionesRequest newDevoluciones) {

        Devoluciones devolucion = new Devoluciones();
        devolucion.setFecha(newDevoluciones.getFecha());
        devolucion.setComentarios(newDevoluciones.getComentarios());

        Estado estado = estadoRepository.findByNombre(newDevoluciones.getNombreEstado()) 
        .orElseThrow(() -> new EntityNotFoundException("no encontrado"));
        devolucion.setEstado(estado);

        Alquiler alquiler = alquilerRepository.findById(newDevoluciones.getIdAlquiler())
        .orElseThrow(() -> new EntityNotFoundException("no se encontro"));
        devolucion.setAlquiler(alquiler);

        Devoluciones saved = devolucionesRepository.save(devolucion);

        ResponseDevoluciones response = new ResponseDevoluciones();
        response.setId(saved.getId()); 
        response.setFecha(saved.getFecha());
        response.setComentarios(saved.getComentarios());
        response.setIdAlquiler(saved.getAlquiler().getId());
        response.setNombreEstado(saved.getEstado().getNombre()); 
       

        return response;
    }

    @Override
    public ResponseDevoluciones UpdateDevoluciones(Long id, DevolucionesRequest req) {

        Devoluciones devolucion = devolucionesRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No se encontró la devolución "));

        if (req.getFecha() != null) {
            devolucion.setFecha(req.getFecha());
        }
        if (req.getComentarios() != null) {
            devolucion.setComentarios(req.getComentarios());
        }

        devolucionesRepository.save(devolucion);

        ResponseDevoluciones response = new ResponseDevoluciones();
        response.setFecha(devolucion.getFecha());
        response.setComentarios(devolucion.getComentarios());

        return response;
    }

}
