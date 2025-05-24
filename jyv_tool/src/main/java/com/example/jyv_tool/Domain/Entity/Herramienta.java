package com.example.jyv_tool.Domain.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
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
    private Categoria categoria;

    @OneToMany(mappedBy = "herramienta", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HerramientaMantenimiento> mantenimientos;

    @OneToMany(mappedBy = "herramienta", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Notificaciones> notificaciones;

    @OneToMany(mappedBy = "herramienta", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Alquiler> alquileres;

    @OneToOne(mappedBy = "herramienta", cascade = CascadeType.ALL)
    @JsonManagedReference
    private DetalleHerramienta detalle;
   
}