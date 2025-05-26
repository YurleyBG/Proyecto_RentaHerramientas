package com.example.jyv_tool.Infraestructure.Repository.Notificaciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.Notificaciones;

@Repository
public interface NotificacionesRepository extends JpaRepository<Notificaciones,Long> {

}
