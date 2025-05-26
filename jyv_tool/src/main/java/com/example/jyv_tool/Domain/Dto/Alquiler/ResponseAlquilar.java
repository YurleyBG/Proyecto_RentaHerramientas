package com.example.jyv_tool.Domain.Dto.Alquiler;

import java.sql.Timestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ResponseAlquilar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp fecha_alquiler,fecha_esperando,fecha_entrega;
    private String estado ;

    
    public ResponseAlquilar(){
      
    }

    public ResponseAlquilar(Long id, Timestamp fecha_alquiler, Timestamp fecha_esperando, Timestamp fecha_entrega,
        String estado) {
      this.id = id;
      this.fecha_alquiler = fecha_alquiler;
      this.fecha_esperando = fecha_esperando;
      this.fecha_entrega = fecha_entrega;
      this.estado = estado;
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public Timestamp getFecha_alquiler() {
      return fecha_alquiler;
    }

    public void setFecha_alquiler(Timestamp fecha_alquiler) {
      this.fecha_alquiler = fecha_alquiler;
    }

    public Timestamp getFecha_esperando() {
      return fecha_esperando;
    }

    public void setFecha_esperando(Timestamp fecha_esperando) {
      this.fecha_esperando = fecha_esperando;
    }

    public Timestamp getFecha_entrega() {
      return fecha_entrega;
    }

    public void setFecha_entrega(Timestamp fecha_entrega) {
      this.fecha_entrega = fecha_entrega;
    }

    public String getEstado() {
      return estado;
    }

    public void setEstado(String estado) {
      this.estado = estado;
    }
    

}
