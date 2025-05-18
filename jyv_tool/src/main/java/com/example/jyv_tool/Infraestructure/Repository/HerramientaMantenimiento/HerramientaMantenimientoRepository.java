package com.example.jyv_tool.Infraestructure.Repository.HerramientaMantenimiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.HerramientaMantenimiento;

@Repository
public interface HerramientaMantenimientoRepository extends JpaRepository<HerramientaMantenimiento, Long> {

}
