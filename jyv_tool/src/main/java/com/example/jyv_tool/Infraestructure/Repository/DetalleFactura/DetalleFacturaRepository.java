package com.example.jyv_tool.Infraestructure.Repository.DetalleFactura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jyv_tool.Domain.Entity.DetalleFactura;

@Repository
public interface  DetalleFacturaRepository extends JpaRepository<DetalleFactura,Long> {

}