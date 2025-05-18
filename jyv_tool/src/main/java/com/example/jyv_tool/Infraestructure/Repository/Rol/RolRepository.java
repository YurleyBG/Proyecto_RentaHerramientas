package com.example.jyv_tool.Infraestructure.Repository.Rol;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {
    Optional<Rol>findByid(Long id);
}
