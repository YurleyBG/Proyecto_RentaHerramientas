package com.example.jyv_tool.Domain.Dto.Herramienta;


import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHerramientas {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    private String nombre;
    private String urlImage;
    private String nombreProveedor;
    private Long categoriaId;
    private Timestamp fecha;
    private int stock ;
    private String marca;
    private String modelo;
    private BigDecimal precio_Diario;
    private String descripcion;


}
