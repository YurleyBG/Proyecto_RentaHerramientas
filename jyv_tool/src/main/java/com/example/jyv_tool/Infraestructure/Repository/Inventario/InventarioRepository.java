package com.example.jyv_tool.Infraestructure.Repository.Inventario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario,Long> {

}
