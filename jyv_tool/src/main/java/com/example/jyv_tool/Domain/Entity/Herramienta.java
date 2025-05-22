package com.example.jyv_tool.Domain.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;



@Entity
public class Herramienta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String UrlImage;

    @OneToMany(mappedBy="herramienta",fetch= FetchType.EAGER)
    private List<Reserva> reservas ;

    @ManyToOne
    @JoinColumn(name = "id_inventario")
    @JsonIgnore
    private Inventario inventario;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonIgnore
    private Categoria categoria;

    @OneToMany(mappedBy = "herramienta")
    @JsonIgnore
    private List<HerramientaMantenimiento> mantenimientos;

    @OneToMany(mappedBy = "herramienta")
    @JsonIgnore
    private List<Notificaciones> notificaciones;

    @OneToMany(mappedBy = "herramienta")
    @JsonIgnore
    private List<Alquiler> alquileres;

    @OneToOne(mappedBy = "herramienta")
    @JsonManagedReference
    private DetalleHerramienta Detalle;
   
    public Herramienta() {
    }

    public Herramienta(String UrlImage, Long id, String nombre) {
        this.UrlImage = UrlImage;
        this.id = id;
        this.nombre = nombre;
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

    public void setUrlImage(String UrlImage) {
        this.UrlImage = UrlImage;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<HerramientaMantenimiento> getMantenimientos() {
        return mantenimientos;
    }

    public void setMantenimientos(List<HerramientaMantenimiento> mantenimientos) {
        this.mantenimientos = mantenimientos;
    }

    public List<Notificaciones> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<Notificaciones> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }

    public DetalleHerramienta getDetalle() {
        return Detalle;
    }

    public void setDetalle(DetalleHerramienta Detalle) {
        this.Detalle = Detalle;
    }

  



}
