package com.example.jyv_tool.Infraestructure.Controller;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jyv_tool.Application.Service.UsuarioService;
import com.example.jyv_tool.Domain.Dto.Usuario.ResponseUsuario;
import com.example.jyv_tool.Domain.Dto.Usuario.UsuarioRequest;
import com.example.jyv_tool.Domain.Entity.Usuario;

@RestController
@RequestMapping(value="/Api" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

   
    private final UsuarioService usuarioservicio;

    public UsuarioController(@Lazy UsuarioService usuarioservicio) {
        this.usuarioservicio = usuarioservicio;
    }

    @GetMapping("/usuario")
    public List<Usuario> findAll() {
        List<Usuario> userResult= usuarioservicio.findAllUsers();
        return userResult;
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable Long id){

        boolean deleteuser= usuarioservicio.deleteUser(id);
        if (deleteuser) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
    @PostMapping("/usuario")
    public ResponseEntity<ResponseUsuario> createNewUsuario(@RequestBody UsuarioRequest newUser) {
        return new ResponseEntity<>(
            usuarioservicio.createNewUsuario(newUser),
            HttpStatus.valueOf(200)
        );
    }

    @PatchMapping("/usuario/{id}")
    public ResponseEntity<ResponseUsuario> UpdateUsuario(@PathVariable Long id,@RequestBody UsuarioRequest users ){
        return ResponseEntity.ok().body(usuarioservicio.UpdateUsuario(id,users));
    }
    

}
