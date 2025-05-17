package com.example.jyv_tool.Domain.Entity;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String  correo,telefono, direccion;
    private Timestamp Fecha_Registro;
    private String Usuario;
    private String contraseña;

    @OneToMany(mappedBy="usuario",fetch= FetchType.EAGER)
    private List<DetalleProveedor> detalles_Proveedores ;
 
 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_localidad")
    @JsonBackReference
    private Localidad localidad;

    @OneToMany(mappedBy = "usuario")
    private List<Multas> multa;

    @OneToMany(mappedBy="Users",fetch= FetchType.EAGER)
    private List<Reserva> reservas ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_Rol",nullable = false)
    @JsonBackReference
    private Rol rol;

    public Usuario() {
    }

    

    public Usuario(Long id, String nombre1, String nombre2, String apellido1, String apellido2, String correo,
            String telefono, String direccion, Timestamp fecha_Registro, String usuario, String contraseña) {
        this.id = id;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.Fecha_Registro = fecha_Registro;
        this.Usuario = usuario;
        this.contraseña = contraseña;
    }



    public String getUsuario() {
        return Usuario;
    }



    public void setUsuario(String usuario) {
        Usuario = usuario;
    }


    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Timestamp getFecha_Registro() {
        return Fecha_Registro;
    }

    public void setFecha_Registro(Timestamp Fecha_Registro) {
        this.Fecha_Registro = Fecha_Registro;
    }

    public List<DetalleProveedor> getDetalles_Proveedores() {
        return detalles_Proveedores;
    }

    public void setDetalles_Proveedores(List<DetalleProveedor> detalles_Proveedores) {
        this.detalles_Proveedores = detalles_Proveedores;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Multas> getMulta() {
        return multa;
    }

    public void setMulta(List<Multas> multa) {
        this.multa = multa;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

}
