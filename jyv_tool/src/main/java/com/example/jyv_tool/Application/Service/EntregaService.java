package com.example.jyv_tool.Application.Service;

import java.util.List;

import com.example.jyv_tool.Domain.Dto.Entrega.EntregaRequest;
import com.example.jyv_tool.Domain.Dto.Entrega.ResponseEntrega;
import com.example.jyv_tool.Domain.Entity.Entrega;

public interface EntregaService {

    List<Entrega>findAllEntrega();
    ResponseEntrega createNewEntrega(EntregaRequest newEntrega );
    ResponseEntrega UpdateEntrega(Long id ,EntregaRequest Entrega);

}
