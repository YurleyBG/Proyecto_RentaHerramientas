package com.example.jyv_tool.Domain.Dto.Usuario;

import java.sql.Timestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ResponseUsuario {
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
    private Long id_rol;

    public ResponseUsuario() {
    }

    public ResponseUsuario(Timestamp Fecha_Registro, String Usuario, String apellido1, String apellido2, String contraseña, String correo, String direccion, Long id, Long id_rol, String nombre1, String nombre2, String telefono) {
        this.Fecha_Registro = Fecha_Registro;
        this.Usuario = Usuario;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.contraseña = contraseña;
        this.correo = correo;
        this.direccion = direccion;
        this.id = id;
        this.id_rol = id_rol;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.telefono = telefono;
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

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }





}
