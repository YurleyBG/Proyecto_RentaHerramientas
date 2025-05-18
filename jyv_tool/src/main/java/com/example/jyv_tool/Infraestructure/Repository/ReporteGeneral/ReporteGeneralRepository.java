package com.example.jyv_tool.Infraestructure.Repository.ReporteGeneral;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.ReporteGeneral;

@Repository
public interface ReporteGeneralRepository extends JpaRepository<ReporteGeneral, Long> {

}
