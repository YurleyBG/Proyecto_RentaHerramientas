package com.example.jyv_tool.Domain.Dto.Entrega;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ResponseEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Estado, direccion_entrega;
    private BigDecimal Costo;
    private Timestamp fecha;

}
