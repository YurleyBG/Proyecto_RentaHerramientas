package com.example.jyv_tool.Infraestructure.Repository.Alquiler;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Alquiler;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler,Long> {

}
