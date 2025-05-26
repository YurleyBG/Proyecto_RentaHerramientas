package com.example.jyv_tool.Domain.Dto.Devoluciones;

import java.sql.Timestamp;


public class DevolucionesRequest {
   
    private Timestamp Fecha;
    private String Comentarios;
    private Long idAlquiler;
    private String nombreEstado;

    

    public DevolucionesRequest() {
    }

    

    public DevolucionesRequest( Timestamp fecha, String comentarios, Long idAlquiler, String nombreEstado) {

        this.Fecha = fecha;
        this.Comentarios = comentarios;
        this.idAlquiler = idAlquiler;
        this.nombreEstado = nombreEstado;
    }




    public Timestamp getFecha() {
        return Fecha;
    }

    public void setFecha(Timestamp fecha) {
        Fecha = fecha;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String comentarios) {
        Comentarios = comentarios;
    }

   

    public String getNombreEstado() {
        return nombreEstado;
    }



    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }



    public Long getIdAlquiler() {
        return idAlquiler;
    }



    public void setIdAlquiler(Long idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    
    
    

}
