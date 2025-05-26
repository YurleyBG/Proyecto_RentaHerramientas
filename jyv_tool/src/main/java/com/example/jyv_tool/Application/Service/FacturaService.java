package com.example.jyv_tool.Application.Service;

import java.util.List;

import com.example.jyv_tool.Domain.Entity.Factura;

public interface FacturaService {

    List<Factura>findAllFactura();
    boolean deleteFactura(Long id);

}
