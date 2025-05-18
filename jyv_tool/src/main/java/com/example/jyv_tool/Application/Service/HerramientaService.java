package com.example.jyv_tool.Application.Service;

import java.util.List;

import com.example.jyv_tool.Domain.Dto.Herramienta.HerramientaRequest;
import com.example.jyv_tool.Domain.Dto.Herramienta.ResponseHerramientas;
import com.example.jyv_tool.Domain.Entity.Herramienta;

public interface HerramientaService {


    List<Herramienta>findAllHerramienta();
    boolean deleteHerramienta(Long id);
    ResponseHerramientas createNewHerramienta(HerramientaRequest newHerramienta );
    ResponseHerramientas UpdateHerramienta(Long id ,HerramientaRequest Herramienta);

}
