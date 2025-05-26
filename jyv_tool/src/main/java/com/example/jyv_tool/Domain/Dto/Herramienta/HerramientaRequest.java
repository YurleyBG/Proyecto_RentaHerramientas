package com.example.jyv_tool.Domain.Dto.Herramienta;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class HerramientaRequest {
  
    private String nombre;
    private String urlImage;
    private String nombreProveedor;
    private Long categoriaId;
    private Timestamp fecha;
    private int stock ;
    private String marca;
    private String modelo;
    private BigDecimal  precio_Diario;
    private String descripcion;


    

}
