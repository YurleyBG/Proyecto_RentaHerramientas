package com.example.jyv_tool.Infraestructure.Repository.Enttega;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega,Long>{

}
