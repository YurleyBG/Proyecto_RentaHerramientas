package com.example.jyv_tool.Domain.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    private String nombre;

    @OneToMany(mappedBy="estados",fetch= FetchType.EAGER)
    @JsonIgnore
    private List<Reserva> reservas ;

    @OneToMany(mappedBy = "estado")
    @JsonIgnore
    private List<HerramientaMantenimiento> mantenimientos;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Devoluciones> devoluciones;

    public Estado(String nombre, Long id) {
        this.nombre = nombre;
        this.id = id;
    }

    public Estado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<HerramientaMantenimiento> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(List<HerramientaMantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public List<Devoluciones> getDevoluciones() {
        return devoluciones;
    }

    public void setDevoluciones(List<Devoluciones> devoluciones) {
        this.devoluciones = devoluciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
