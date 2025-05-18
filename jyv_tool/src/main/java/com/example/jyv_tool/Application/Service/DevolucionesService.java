package com.example.jyv_tool.Application.Service;

import java.util.List;

import com.example.jyv_tool.Domain.Dto.Devoluciones.DevolucionesRequest;
import com.example.jyv_tool.Domain.Dto.Devoluciones.ResponseDevoluciones;
import com.example.jyv_tool.Domain.Entity.Devoluciones;

public interface  DevolucionesService {

    List<Devoluciones>findAllDevoluciones();
    boolean deleteDevoluciones(Long id);
    ResponseDevoluciones createNewDevoluciones(DevolucionesRequest newDevoluciones );
    ResponseDevoluciones UpdateDevoluciones(Long id ,DevolucionesRequest Devoluciones);

}
