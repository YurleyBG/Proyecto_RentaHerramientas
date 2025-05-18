package com.example.jyv_tool.Domain.Dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class FacturaRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero_factura;
    private Timestamp fecha;
    private BigDecimal Monto_total;

    



}
