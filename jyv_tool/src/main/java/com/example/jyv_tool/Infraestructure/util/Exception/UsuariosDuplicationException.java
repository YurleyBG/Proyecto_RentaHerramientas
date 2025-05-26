package com.example.jyv_tool.Infraestructure.util.Exception;

import org.springframework.http.HttpStatus;

public class UsuariosDuplicationException extends RuntimeException{

    private HttpStatus status;
    private String Mensajito;

     public UsuariosDuplicationException(String Mensajito, HttpStatus statusCode){
        super(Mensajito);
        this.Mensajito=Mensajito;
        this.status=statusCode;
    }
    public String getMensajito() {
        return Mensajito;
    }

    public void setMensajito(String Mensajito) {
        this.Mensajito = Mensajito;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}
