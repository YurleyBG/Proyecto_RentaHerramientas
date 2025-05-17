package com.example.jyv_tool.Domain.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class DetalleProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nit;
    private String Nombre_empresa;
    private String direccion, telefono;
    private String Correo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_proveedor",nullable = false)
    private Usuario usuario;


    public DetalleProveedor() {
    }

    public DetalleProveedor(String Correo, String Nombre_empresa, String direccion, Long id, String nit, String telefono) {
        this.Correo = Correo;
        this.Nombre_empresa = Nombre_empresa;
        this.direccion = direccion;
        this.id = id;
        this.nit = nit;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre_empresa() {
        return Nombre_empresa;
    }

    public void setNombre_empresa(String Nombre_empresa) {
        this.Nombre_empresa = Nombre_empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
