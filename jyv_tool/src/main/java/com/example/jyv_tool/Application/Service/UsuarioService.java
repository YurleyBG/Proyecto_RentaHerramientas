package com.example.jyv_tool.Application.Service;

import java.util.List;

import com.example.jyv_tool.Domain.Dto.Usuario.ResponseUsuario;
import com.example.jyv_tool.Domain.Dto.Usuario.UsuarioRequest;
import com.example.jyv_tool.Domain.Entity.Usuario;

public interface  UsuarioService {
    
    List<Usuario>findAllUsers();
    boolean deleteUser(Long id);
    ResponseUsuario createNewUsuario(UsuarioRequest newUser );
    ResponseUsuario UpdateUsuario(Long id , UsuarioRequest user);

}
