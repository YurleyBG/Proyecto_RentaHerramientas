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

    
    public ResponseEntrega(Long id, String estado, String direccion_entrega, BigDecimal costo, Timestamp fecha) {
        this.id = id;
        Estado = estado;
        this.direccion_entrega = direccion_entrega;
        Costo = costo;
        this.fecha = fecha;
    }
    public ResponseEntrega() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getDireccion_entrega() {
        return direccion_entrega;
    }
    public void setDireccion_entrega(String direccion_entrega) {
        this.direccion_entrega = direccion_entrega;
    }
    public BigDecimal getCosto() {
        return Costo;
    }
    public void setCosto(BigDecimal costo) {
        Costo = costo;
    }
    public Timestamp getFecha() {
        return fecha;
    }
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    

}
