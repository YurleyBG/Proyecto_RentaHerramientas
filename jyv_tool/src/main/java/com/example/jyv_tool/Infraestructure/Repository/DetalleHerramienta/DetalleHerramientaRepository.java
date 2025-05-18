package com.example.jyv_tool.Infraestructure.Repository.DetalleHerramienta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jyv_tool.Domain.Entity.DetalleHerramienta;

@Repository
public interface DetalleHerramientaRepository extends JpaRepository<DetalleHerramienta,Long> {

}