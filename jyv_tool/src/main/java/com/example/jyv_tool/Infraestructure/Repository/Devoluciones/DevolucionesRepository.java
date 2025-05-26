package com.example.jyv_tool.Infraestructure.Repository.Devoluciones;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Devoluciones;

@Repository
public interface DevolucionesRepository extends JpaRepository<Devoluciones,Long>{
    
    Optional<Devoluciones>findByid(Long id);
}
