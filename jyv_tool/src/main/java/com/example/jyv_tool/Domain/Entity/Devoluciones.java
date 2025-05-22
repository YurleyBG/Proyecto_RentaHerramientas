package com.example.jyv_tool.Domain.Entity;



import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class Devoluciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp Fecha;
    private String Comentarios;

    @ManyToOne
    @JoinColumn(name = "id_alquiler")
    @JsonIgnore
    private Alquiler alquiler;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado",nullable = false)
    @JsonIgnore
    private Estado estado;


    public Devoluciones(String Comentarios, Timestamp Fecha, Long id) {
        this.Comentarios = Comentarios;
        this.Fecha = Fecha;
        this.id = id;
    }

    public Devoluciones() {
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

    public void setFecha(Timestamp Fecha) {
        this.Fecha = Fecha;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String Comentarios) {
        this.Comentarios = Comentarios;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
