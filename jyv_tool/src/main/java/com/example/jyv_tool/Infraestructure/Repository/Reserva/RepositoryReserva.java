package com.example.jyv_tool.Infraestructure.Repository.Reserva;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jyv_tool.Domain.Entity.Reserva;

@Repository
public interface  RepositoryReserva extends JpaRepository<Reserva, Long>{

    Optional<Reserva>findByid(Long id);
}
