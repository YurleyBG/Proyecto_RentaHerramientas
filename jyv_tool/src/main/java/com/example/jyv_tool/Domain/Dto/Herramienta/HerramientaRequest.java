package com.example.jyv_tool.Domain.Dto.Herramienta;

import java.math.BigDecimal;

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
    private String UrlImage;

    private Long categoriaId;

    private String Marca;
    private String Modelo;
    private BigDecimal  Precio_Diario;
    private String Descripcion;


    

}
