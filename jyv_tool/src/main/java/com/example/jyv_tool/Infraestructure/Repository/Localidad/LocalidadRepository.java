package com.example.jyv_tool.Infraestructure.Repository.Localidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Localidad;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Long> {

}
