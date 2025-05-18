package com.example.jyv_tool.Domain.Dto.Factura;

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

    

    public FacturaRequest() {
    }
    public FacturaRequest(Long id, String numero_factura, Timestamp fecha, BigDecimal monto_total) {
        this.id = id;
        this.numero_factura = numero_factura;
        this.fecha = fecha;
        Monto_total = monto_total;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNumero_factura() {
        return numero_factura;
    }
    public void setNumero_factura(String numero_factura) {
        this.numero_factura = numero_factura;
    }
    public Timestamp getFecha() {
        return fecha;
    }
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    public BigDecimal getMonto_total() {
        return Monto_total;
    }
    public void setMonto_total(BigDecimal monto_total) {
        Monto_total = monto_total;
    }


    

    



}
