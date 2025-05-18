package com.example.jyv_tool.Infraestructure.Repository.Pago;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Pago;

@Repository
public interface PagoRepository extends JpaRepository<Pago,Long>{

}
