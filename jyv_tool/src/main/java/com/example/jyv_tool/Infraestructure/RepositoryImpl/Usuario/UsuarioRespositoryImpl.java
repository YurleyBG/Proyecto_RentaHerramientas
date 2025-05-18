package com.example.jyv_tool.Infraestructure.RepositoryImpl.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.jyv_tool.Application.Service.UsuarioService;
import com.example.jyv_tool.Domain.Dto.ResponseUsuario;
import com.example.jyv_tool.Domain.Dto.UsuarioRequest;
import com.example.jyv_tool.Domain.Entity.Rol;
import com.example.jyv_tool.Domain.Entity.Usuario;
import com.example.jyv_tool.Infraestructure.Repository.Rol.RolRepository;
import com.example.jyv_tool.Infraestructure.Repository.Usuario.UsuarioRepository;
import com.example.jyv_tool.Infraestructure.util.Exception.UsuariosDuplicationException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioRespositoryImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolrepository;
    
    public UsuarioRespositoryImpl(UsuarioRepository usuarioRepository,RolRepository rolrepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolrepository= rolrepository;
    }

    @Override
    public List<Usuario> findAllUsers() {
        return usuarioRepository.findAll();
    }

    @Override
    public boolean deleteUser(Long id) {
        Optional<Usuario> userRemove =usuarioRepository.findById(id);
        if (userRemove.isPresent()) {
            usuarioRepository.deleteById(id);
            return true;
        } 
        return false;
    }

    @Override
    public ResponseUsuario createNewUsuario(UsuarioRequest newUser) {
        Optional<Usuario> user = usuarioRepository.findByid(newUser.getId());
        if (user.isPresent()){
            throw new UsuariosDuplicationException("El Usuario ya se encuentra registrado", HttpStatus.CONFLICT);
        }
        Usuario nuevousers = new Usuario();
        nuevousers.setNombre1(newUser.getNombre1());
        nuevousers.setNombre2(newUser.getNombre2());
        nuevousers.setApellido1(newUser.getApellido2());
        nuevousers.setApellido2(newUser.getApellido2());
        nuevousers.setCorreo(newUser.getCorreo());
        nuevousers.setDireccion(newUser.getDireccion());
        nuevousers.setTelefono(newUser.getTelefono());
        nuevousers.setContraseña(newUser.getContraseña());
        nuevousers.setUsuario(newUser.getUsuario());
        Long roleId = newUser.getId_rol();
        Rol rolcito = rolrepository.findById(roleId).orElseThrow(() -> new RuntimeException("Rol no encontrado con ID: " + roleId));
        nuevousers.setRol(rolcito);


        Usuario UserSave = usuarioRepository.save(nuevousers);
        ResponseUsuario Userresp = new ResponseUsuario();
        Userresp.setNombre1(UserSave.getNombre1());
        Userresp.setNombre2(UserSave.getNombre2());
        Userresp.setApellido1(UserSave.getApellido2());
        Userresp.setApellido2(UserSave.getApellido2());
        Userresp.setCorreo(UserSave.getCorreo());
        Userresp.setDireccion(UserSave.getDireccion());
        Userresp.setTelefono(UserSave.getTelefono());
        Userresp.setContraseña(UserSave.getContraseña());
        Userresp.setUsuario(UserSave.getUsuario());
        Userresp.setId_rol(UserSave.getRol().getId());

        return Userresp;
    }

    @Override
    public ResponseUsuario UpdateUsuario(Long id, UsuarioRequest user) {
        Usuario usuar= usuarioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No se encontro el Usuario con la id solicitada"));

        if(user.getNombre1()!=null){
            usuar.setNombre1(user.getNombre1());
        }
        if(user.getNombre2()!=null){
            usuar.setNombre2(user.getNombre2());
        }
        if(user.getApellido1()!=null){
            usuar.setApellido1(user.getApellido1());
        }
        if(user.getApellido2()!=null){
            usuar.setApellido2(user.getApellido2());
        }
          if(user.getCorreo()!=null){
            usuar.setCorreo(user.getCorreo());
        }
        if(user.getDireccion()!=null){
            usuar.setDireccion(user.getDireccion());
        }
        if(user.getTelefono()!=null){
            usuar.setTelefono(user.getTelefono());
        }
        if(user.getContraseña()!=null){
            usuar.setContraseña(user.getContraseña());
        }
        if(user.getUsuario()!=null){
            usuar.setUsuario(user.getUsuario());
        }

        usuarioRepository.save(usuar);
        ResponseUsuario resp = new ResponseUsuario();
        resp.setNombre1(usuar.getNombre1());
        resp.setNombre2(usuar.getNombre2());
        resp.setApellido1(usuar.getApellido1());
        resp.setApellido2(usuar.getApellido2());
        resp.setCorreo(usuar.getCorreo());
        resp.setDireccion(usuar.getDireccion());
        resp.setTelefono(usuar.getTelefono());
        resp.setContraseña(usuar.getContraseña());
        resp.setUsuario(usuar.getUsuario());
        return resp;
       
 
    }

}
