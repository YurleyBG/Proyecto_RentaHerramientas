package com.example.jyv_tool.Application.Service;

import java.util.List;

import com.example.jyv_tool.Domain.Dto.Multa.MultaRequest;
import com.example.jyv_tool.Domain.Dto.Multa.ResponseMulta;
import com.example.jyv_tool.Domain.Entity.Multas;

public interface MultaService {

    List<Multas>findAllMulta();
    ResponseMulta createNewMulta(MultaRequest newMulta );
    ResponseMulta UpdateMulta(Long id ,MultaRequest Multa);

}
