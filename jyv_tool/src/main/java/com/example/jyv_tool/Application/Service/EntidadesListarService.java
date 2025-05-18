package com.example.jyv_tool.Application.Service;

import java.util.List;

import com.example.jyv_tool.Domain.Entity.Categoria;
import com.example.jyv_tool.Domain.Entity.DetalleFactura;
import com.example.jyv_tool.Domain.Entity.DetalleHerramienta;
import com.example.jyv_tool.Domain.Entity.DetalleProveedor;
import com.example.jyv_tool.Domain.Entity.Estado;
import com.example.jyv_tool.Domain.Entity.FormaPago;
import com.example.jyv_tool.Domain.Entity.HerramientaMantenimiento;
import com.example.jyv_tool.Domain.Entity.Localidad;
import com.example.jyv_tool.Domain.Entity.Notificaciones;
import com.example.jyv_tool.Domain.Entity.ReporteGeneral;
import com.example.jyv_tool.Domain.Entity.Rol;

public interface  EntidadesListarService {

    List<Rol>findAllRol();
    List<Localidad>findAllLocalidad();
    List<DetalleProveedor>findAllDP();
    List<ReporteGeneral>findAllRG();
    List<FormaPago>findAllFP();
    List<DetalleFactura>findAllDF();
    List<Notificaciones>findAllNoti();
    List<Estado>findAllEstados();
    List<HerramientaMantenimiento>findAllHM();
    List<Categoria>findAllCategorias();
    List<DetalleHerramienta>findAllDH();

}
