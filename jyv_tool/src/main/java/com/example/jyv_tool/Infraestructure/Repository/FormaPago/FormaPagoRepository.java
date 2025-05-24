package com.example.jyv_tool.Infraestructure.Repository.FormaPago;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.FormaPago;

@Repository
public interface FormaPagoRepository extends JpaRepository<FormaPago,Long> {

    Optional<FormaPago> findByMetodopago(String metodoPago);

}
