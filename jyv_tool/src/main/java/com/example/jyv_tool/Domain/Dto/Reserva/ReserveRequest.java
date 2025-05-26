package com.example.jyv_tool.Domain.Dto.Reserva;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ReserveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp fecha_inicio , fecha_fin;
    private BigDecimal costo_total;
    private int cantidad;
    private String nombreCliente;   
    private String nombreEstado;
    private String nombreHerramienta;

    public ReserveRequest() {
    }
    
    

    public ReserveRequest(Long id, Timestamp fecha_inicio, Timestamp fecha_fin, BigDecimal costo_total, int cantidad,
            String nombreCliente, String nombreEstado, String nombreHerramienta) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.costo_total = costo_total;
        this.cantidad = cantidad;
        this.nombreCliente = nombreCliente;
        this.nombreEstado = nombreEstado;
        this.nombreHerramienta = nombreHerramienta;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Timestamp fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Timestamp getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Timestamp fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public BigDecimal getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(BigDecimal costo_total) {
        this.costo_total = costo_total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }



    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }



    public String getNombreEstado() {
        return nombreEstado;
    }



    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }



    public String getNombreHerramienta() {
        return nombreHerramienta;
    }



    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }



    

    

}
