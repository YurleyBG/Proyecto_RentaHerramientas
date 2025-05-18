package com.example.jyv_tool.Domain.Dto.Herramienta;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class HerramientaRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String UrlImage;

    

    public HerramientaRequest() {
    }
    public HerramientaRequest(Long id, String nombre, String urlImage) {
        this.id = id;
        this.nombre = nombre;
        UrlImage = urlImage;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUrlImage() {
        return UrlImage;
    }
    public void setUrlImage(String urlImage) {
        UrlImage = urlImage;
    }


    

}
