package com.example.jyv_tool.Domain.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp fecha_inicio , fecha_fin;
    private BigDecimal costo_total;
    private int cantidad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_Cliente",nullable = false)
    @JsonIgnore
    private Usuario users;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_Estado",nullable = false)
    @JsonIgnore
    private Estado estados;

    @ManyToOne
    @JoinColumn(name = "id_Herramienta")
    @JsonIgnore
    private Herramienta herramienta;


    public Reserva(BigDecimal costo_total, Timestamp fecha_fin, Timestamp fecha_inicio, Long id, int cantidad) {
        this.costo_total = costo_total;
        this.fecha_fin = fecha_fin;
        this.fecha_inicio = fecha_inicio;
        this.id = id;
        this.cantidad=cantidad;
    }

    public Reserva() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Timestamp fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Timestamp getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Timestamp fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public BigDecimal getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(BigDecimal costo_total) {
        this.costo_total = costo_total;
    }

   

    public Estado getEstados() {
        return estados;
    }

    public void setEstados(Estado estados) {
        this.estados = estados;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Usuario getUsers() {
        return users;
    }

    public void setUsers(Usuario users) {
        this.users = users;
    }
    

}
