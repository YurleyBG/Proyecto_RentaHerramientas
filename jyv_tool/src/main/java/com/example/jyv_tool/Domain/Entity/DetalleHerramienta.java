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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class DetalleHerramienta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Marca;
    private String Modelo;
    private BigDecimal  Precio_Diario;
    private String Descripcion;

    @OneToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name = "id_Herramienta", nullable = false) 
    @JsonBackReference
    private Herramienta herramienta;
 
}
