package com.example.jyv_tool.Domain.Entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;



@Entity
public class DetalleHerramienta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Marca;
    private String Modelo;
    private BigDecimal  Precio_Diario;
    private String Descripcion;

    @OneToOne(fetch = FetchType.LAZY) 
    @JoinColumn(name = "id_Herramienta", nullable = false) 
    @JsonBackReference
    private Herramienta herramienta;
 
    public DetalleHerramienta(String Descripcion, String Marca, String Modelo, BigDecimal Precio_Diario, Long id) {
        this.Descripcion = Descripcion;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Precio_Diario = Precio_Diario;
        this.id = id;
    }

    public DetalleHerramienta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public BigDecimal getPrecio_Diario() {
        return Precio_Diario;
    }

    public void setPrecio_Diario(BigDecimal Precio_Diario) {
        this.Precio_Diario = Precio_Diario;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    
  
    
    

}
