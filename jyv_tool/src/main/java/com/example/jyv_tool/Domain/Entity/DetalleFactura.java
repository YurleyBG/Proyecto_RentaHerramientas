package com.example.jyv_tool.Domain.Entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;



@Entity
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Descripcion;
    private int Cantidad;
    private BigDecimal Monto_Unitario;

    @OneToOne
    @JoinColumn(name = "id_factura")
    @JsonIgnore
    private Factura factura;


    public DetalleFactura() {
    }

    public DetalleFactura(int Cantidad, String Descripcion, BigDecimal Monto_Unitario, Long id) {
        this.Cantidad = Cantidad;
        this.Descripcion = Descripcion;
        this.Monto_Unitario = Monto_Unitario;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public BigDecimal getMonto_Unitario() {
        return Monto_Unitario;
    }

    public void setMonto_Unitario(BigDecimal Monto_Unitario) {
        this.Monto_Unitario = Monto_Unitario;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
    

}
