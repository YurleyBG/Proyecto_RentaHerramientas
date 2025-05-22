
package com.example.jyv_tool.Infraestructure.RepositoryImpl.Herramienta;


public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String mensajito){
        super(mensajito);
    }

}
