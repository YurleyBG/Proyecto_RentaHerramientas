package com.example.jyv_tool.Infraestructure.Repository.Categoria;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
    
    Optional<Categoria>findByid(Long id);
}
