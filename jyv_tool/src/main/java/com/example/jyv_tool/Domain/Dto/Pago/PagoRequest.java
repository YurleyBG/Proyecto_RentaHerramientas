package com.example.jyv_tool.Domain.Dto.Pago;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class PagoRequest {

    private BigDecimal monto;
    private Timestamp fecha;
    private Long idReserva; 
    private String formaPago;

    

    public PagoRequest() {
    }
    
    public PagoRequest( BigDecimal monto, Timestamp fecha, Long idReserva, String formaPago) {
  
        this.monto = monto;
        this.fecha = fecha;
        this.idReserva = idReserva;
        this.formaPago = formaPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    public Timestamp getFecha() {
        return fecha;
    }
    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    public Long getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    

    

}
