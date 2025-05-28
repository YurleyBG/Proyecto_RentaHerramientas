package com.example.jyv_tool.Infraestructure.Repository.Herramienta;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Herramienta;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta,Long>{

    Optional<Herramienta>findByid(Long id);
    Optional<Herramienta>findByNombre(String nombre);
    List<Herramienta> findByNombreContainingIgnoreCase(String searchTerm);
    List<Herramienta> findByCategoria_NombreIgnoreCase(String category);
    List<Herramienta> findByInventario_StockGreaterThan(Integer stock);

}
