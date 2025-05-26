package com.example.jyv_tool.Auth;


import  org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.jyv_tool.Domain.Entity.Rol;
import com.example.jyv_tool.Domain.Entity.Usuario;
import com.example.jyv_tool.Infraestructure.Repository.Rol.RolRepository;
import com.example.jyv_tool.Infraestructure.Repository.Usuario.UsuarioRepository;
import com.example.jyv_tool.Jwt.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final RolRepository rolRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager; 

    public AuthResponse login( LoginRequest request){
        
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        UserDetails user = (UserDetails) authentication.getPrincipal();
        String token = jwtService.getToken(user);

        String role = user.getAuthorities().stream()
        .findFirst()
        .map(a -> a.getAuthority()) 
        .orElse("UNKNOWN");

        return AuthResponse.builder()
        .token(token)
        .role(role)
        .build();

    }
    public AuthResponse register( RegisterRequest request){

        if (usuarioRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Nombre de usuario ya existe");
        }
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        Rol rol = rolRepository.findByNombre(request.getRol())
            .orElseThrow(() -> new RuntimeException("Rol '" + request.getRol() + "' No se encontro"));

        Usuario usuario = Usuario.builder()
            .nombre1(request.getNombre())
            .nombre2(null)
            .apellido1(request.getApellido())
            .apellido2(null) 
            .correo(request.getEmail())
            .username(request.getUsername())
            .telefono(null)
            .direccion(null)
            .password(encodedPassword)
            .rol(rol)
            .build();

        usuarioRepository.save(usuario);
        
        String jwtToken = jwtService.getToken(usuario);
        
        return AuthResponse.builder()
            .token(jwtToken)
            .build();
    }

}
