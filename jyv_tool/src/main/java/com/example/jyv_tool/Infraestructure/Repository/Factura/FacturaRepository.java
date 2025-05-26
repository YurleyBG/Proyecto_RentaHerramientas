package com.example.jyv_tool.Infraestructure.Repository.Factura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long>{

}
