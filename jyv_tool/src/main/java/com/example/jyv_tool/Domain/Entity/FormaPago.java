package com.example.jyv_tool.Domain.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class FormaPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Metodo_pago;

    @OneToMany(mappedBy = "formaPago")
    @JsonIgnore
    private List<Pago> pagos;


    public FormaPago(String Metodo_pago, Long id) {
        this.Metodo_pago = Metodo_pago;
        this.id = id;
    }

    public FormaPago() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMetodo_pago() {
        return Metodo_pago;
    }

    public void setMetodo_pago(String Metodo_pago) {
        this.Metodo_pago = Metodo_pago;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }


}
