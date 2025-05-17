package com.example.jyv_tool.Domain.Entity;

import java.util.List;

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
    private String Nombre;

    @OneToMany(mappedBy="estados",fetch= FetchType.EAGER)
    private List<Reserva> reservas ;

    @OneToMany(mappedBy = "estado")
    private List<HerramientaMantenimiento> mantenimientos;

    @OneToMany(mappedBy = "estado")
    private List<Devoluciones> devoluciones;

    public Estado(String Nombre, Long id) {
        this.Nombre = Nombre;
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

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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

}
