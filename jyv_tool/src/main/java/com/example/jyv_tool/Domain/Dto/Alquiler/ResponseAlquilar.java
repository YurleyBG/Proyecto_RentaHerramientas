package com.example.jyv_tool.Domain.Dto.Alquiler;

import java.sql.Timestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ResponseAlquilar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp fecha_alquiler,fecha_esperando,fecha_entrega;
    private String estado ;

}
