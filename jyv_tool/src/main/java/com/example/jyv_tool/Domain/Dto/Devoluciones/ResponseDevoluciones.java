package com.example.jyv_tool.Domain.Dto.Devoluciones;

import java.sql.Timestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ResponseDevoluciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp Fecha;
    private String Comentarios;
    private Long idAlquiler;
    private String nombreEstado;

    
    public ResponseDevoluciones() {
    }

    public ResponseDevoluciones(Long id, Timestamp fecha, String comentarios, Long idAlquiler, String nombreEstado) {
        this.id = id;
        this.Fecha = fecha;
        this.Comentarios = comentarios;
        this.idAlquiler = idAlquiler;
        this.nombreEstado = nombreEstado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return Fecha;
    }

    public void setFecha(Timestamp fecha) {
        Fecha = fecha;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String comentarios) {
        Comentarios = comentarios;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public Long getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(Long idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    

}
