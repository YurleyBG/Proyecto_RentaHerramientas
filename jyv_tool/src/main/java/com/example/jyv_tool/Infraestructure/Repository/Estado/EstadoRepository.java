package com.example.jyv_tool.Infraestructure.Repository.Estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Long>{

}
