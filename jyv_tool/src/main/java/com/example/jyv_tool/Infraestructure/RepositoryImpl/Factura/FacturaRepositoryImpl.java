package com.example.jyv_tool.Infraestructure.RepositoryImpl.Factura;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.jyv_tool.Application.Service.FacturaService;
import com.example.jyv_tool.Domain.Entity.Factura;
import com.example.jyv_tool.Infraestructure.Repository.Factura.FacturaRepository;

@Service
public class FacturaRepositoryImpl implements FacturaService {

    private final FacturaRepository facturaRepository;

    public FacturaRepositoryImpl(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Factura> findAllFactura() {
        return facturaRepository.findAll();
    }

    @Override
    public boolean deleteFactura(Long id) {
        Optional<Factura> facturaOptional = facturaRepository.findById(id);
        if (facturaOptional.isPresent()) {
            facturaRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
