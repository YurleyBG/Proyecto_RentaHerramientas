package com.example.jyv_tool.Infraestructure.Repository.Herramienta;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Herramienta;
import com.example.jyv_tool.Domain.Entity.Usuario;

@Repository
public interface HerramientaRepository extends JpaRepository<Herramienta,Long>{

    Optional<Usuario>findByid(Long id);
    Optional<Usuario>findByNombre(String nombre);

}
