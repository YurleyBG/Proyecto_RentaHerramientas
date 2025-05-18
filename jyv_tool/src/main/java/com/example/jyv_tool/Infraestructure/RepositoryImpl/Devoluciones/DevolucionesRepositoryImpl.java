package com.example.jyv_tool.Infraestructure.RepositoryImpl.Devoluciones;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.jyv_tool.Application.Service.DevolucionesService;
import com.example.jyv_tool.Domain.Dto.Devoluciones.DevolucionesRequest;
import com.example.jyv_tool.Domain.Dto.Devoluciones.ResponseDevoluciones;
import com.example.jyv_tool.Domain.Entity.Devoluciones;
import com.example.jyv_tool.Infraestructure.Repository.Devoluciones.DevolucionesRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DevolucionesRepositoryImpl implements  DevolucionesService {

    private final DevolucionesRepository devolucionesRepository;

    public DevolucionesRepositoryImpl(@Lazy DevolucionesRepository devolucionesRepository) {
        this.devolucionesRepository = devolucionesRepository;
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

        Devoluciones saved = devolucionesRepository.save(devolucion);

        ResponseDevoluciones response = new ResponseDevoluciones();
        response.setFecha(saved.getFecha());
        response.setComentarios(saved.getComentarios());

        return response;
    }

    @Override
    public ResponseDevoluciones UpdateDevoluciones(Long id, DevolucionesRequest req) {
        Devoluciones devolucion = devolucionesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la devolución con la id solicitada"));

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
