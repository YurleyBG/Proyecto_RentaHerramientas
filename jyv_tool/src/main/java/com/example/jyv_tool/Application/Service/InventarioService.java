package com.example.jyv_tool.Application.Service;

import java.util.List;

import com.example.jyv_tool.Domain.Dto.Inventario.InventarioRequest;
import com.example.jyv_tool.Domain.Dto.Inventario.ResponseInventario;
import com.example.jyv_tool.Domain.Entity.Inventario;

public interface InventarioService {

    List<Inventario>findAllInventario();
    ResponseInventario createNewInventario(InventarioRequest newInventario);
    ResponseInventario UpdateInventario(Long id ,InventarioRequest Inventario);

}
