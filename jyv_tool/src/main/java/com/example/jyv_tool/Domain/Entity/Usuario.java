package com.example.jyv_tool.Domain.Entity;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String correo,telefono, direccion;
    private String username;
    private String password;

    @OneToMany(mappedBy="usuario",fetch= FetchType.EAGER)
    @JsonIgnore
    private List<DetalleProveedor> detalles_Proveedores ;
 
 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_localidad")
    @JsonBackReference
    private Localidad localidad;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Multas> multa;

    @OneToMany(mappedBy="Users",fetch= FetchType.EAGER)
    @JsonIgnore
    private List<Reserva> reservas ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_Rol",nullable = false)
    @JsonBackReference
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Notificaciones> notificaciones;

    @OneToMany(mappedBy = "proveedorUsuario") 
    @JsonIgnore
    private List<Inventario> inventarios;


    public Usuario(Long id, String nombre1, String nombre2, String apellido1, String apellido2, String correo,
            String telefono, String direccion, String username, String password) {
        this.id = id;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.username = username;
        this.password = password;
    }

 

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((rol.getNombre())));
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public  boolean isAccountNonLocked(){
        return true;

    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }

   

}
