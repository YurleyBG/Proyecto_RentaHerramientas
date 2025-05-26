package com.example.jyv_tool.Domain.Dto.Inventario;

import java.sql.Timestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class InventarioRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp fecha;
    private int stock ;

    public InventarioRequest() {
    }
    public InventarioRequest(Long id, Timestamp fecha, int stock) {
        this.id = id;
        this.fecha = fecha;
        this.stock = stock;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Timestamp getFecha() {
        return fecha;
    }
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    

}
