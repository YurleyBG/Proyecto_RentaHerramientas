package com.example.jyv_tool.Infraestructure.Repository.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jyv_tool.Domain.Entity.Usuario;


@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario>findByid(Long id);
    Optional<Usuario>findByUsername(String username);

}
