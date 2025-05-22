package com.example.jyv_tool.Domain.Dto.Herramienta;


import java.math.BigDecimal;

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
    private String UrlImage;

    private Long categoriaId;

    private String Marca;
    private String Modelo;
    private BigDecimal  Precio_Diario;
    private String Descripcion;
}
