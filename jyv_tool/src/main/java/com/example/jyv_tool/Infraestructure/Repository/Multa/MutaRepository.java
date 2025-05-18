package com.example.jyv_tool.Infraestructure.Repository.Multa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Multas;

@Repository
public interface MutaRepository extends JpaRepository<Multas,Long>{

}
