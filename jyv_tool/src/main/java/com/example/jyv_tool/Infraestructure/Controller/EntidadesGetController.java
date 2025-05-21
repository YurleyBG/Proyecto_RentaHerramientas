package com.example.jyv_tool.Infraestructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jyv_tool.Application.Service.EntidadesListarService;
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
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value="/Api" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class EntidadesGetController {

    
    private final EntidadesListarService entidadesGetService;
    
    public EntidadesGetController(@Lazy EntidadesListarService entidadesGetService) {
        this.entidadesGetService = entidadesGetService;
    }
    @GetMapping("/rol")
    public List<Rol> findAllRol() {
        List<Rol> rolResult = entidadesGetService.findAllRol();
        return rolResult;
    }

    @GetMapping("/categoria")
    public List<Categoria> findAll() {
        List<Categoria> CateResult = entidadesGetService.findAllCategorias();
        return CateResult;
    }
    @GetMapping("/localidad")
    public List<Localidad> findAllLocalidad() {
        List<Localidad> LocalResult = entidadesGetService.findAllLocalidad();
        return LocalResult;
    }
    @GetMapping("/DP")
    public List<DetalleProveedor> findAllDP() {
        List<DetalleProveedor> DPResult = entidadesGetService.findAllDP();
        return DPResult;
    }

    @GetMapping("/RP")
    public List<ReporteGeneral> findAllRG() {
        List<ReporteGeneral> RPResult = entidadesGetService.findAllRG();
        return RPResult;
    }
    @GetMapping("/FP")
    public List<FormaPago> findAllFP() {
        List<FormaPago> FPResult = entidadesGetService.findAllFP();
        return FPResult;
    }
    @GetMapping("/DF")
    public List<DetalleFactura> findAllDF() {
        List<DetalleFactura> DFResult = entidadesGetService.findAllDF();
        return DFResult;
    }

    @GetMapping("/Noti")
    public List<Notificaciones> findAllNoti() {
        List<Notificaciones> notiResult = entidadesGetService.findAllNoti();
        return notiResult;
    }
    @GetMapping("/estado")
    public List<Estado> findAllEstados() {
        List<Estado> EstadoResult = entidadesGetService.findAllEstados();
        return EstadoResult;
    }
    @GetMapping("/HM")
    public List<HerramientaMantenimiento> findAllHM() {
        List<HerramientaMantenimiento> HMResult = entidadesGetService.findAllHM();
        return HMResult;
    }
    @GetMapping("/DH")
    public List<DetalleHerramienta> findAllDH() {
        List<DetalleHerramienta> EstadoResult = entidadesGetService.findAllDH();
        return EstadoResult;
    }


}
