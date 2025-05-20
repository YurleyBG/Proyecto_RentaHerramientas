package com.example.jyv_tool.Auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import  lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    String username;
    String password;
    String nombre;
    String apellido;
    String rol;
    String email;

}
