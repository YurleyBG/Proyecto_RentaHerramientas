package com.example.jyv_tool.Domain.Dto.Pago;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ResponsePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal monto;
    private Timestamp fecha;
    private Long idReserva; 
    private String formaPago;

    public ResponsePago(Long id, BigDecimal monto, Timestamp fecha, Long idReserva, String formaPago) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.idReserva = idReserva;
        this.formaPago = formaPago;
    }

    public ResponsePago() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public Timestamp getFecha() {
        return fecha;
    }
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    public Long getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    
    
    




}
