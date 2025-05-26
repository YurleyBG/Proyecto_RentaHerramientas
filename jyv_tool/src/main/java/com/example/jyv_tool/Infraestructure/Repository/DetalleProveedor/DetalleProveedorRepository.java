package com.example.jyv_tool.Infraestructure.Repository.DetalleProveedor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jyv_tool.Domain.Entity.DetalleProveedor;

@Repository
public interface  DetalleProveedorRepository extends JpaRepository< DetalleProveedor, Long>{

}
