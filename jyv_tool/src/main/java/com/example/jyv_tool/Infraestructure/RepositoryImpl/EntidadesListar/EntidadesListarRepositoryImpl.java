package com.example.jyv_tool.Infraestructure.RepositoryImpl.EntidadesListar;

import java.util.List;

import org.springframework.stereotype.Service;

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
import com.example.jyv_tool.Infraestructure.Repository.Categoria.CategoriaRepository;
import com.example.jyv_tool.Infraestructure.Repository.DetalleFactura.DetalleFacturaRepository;
import com.example.jyv_tool.Infraestructure.Repository.DetalleProveedor.DetalleProveedorRepository;
import com.example.jyv_tool.Infraestructure.Repository.Estado.EstadoRepository;
import com.example.jyv_tool.Infraestructure.Repository.Notificaciones.NotificacionesRepository;
import com.example.jyv_tool.Infraestructure.Repository.ReporteGeneral.ReporteGeneralRepository;
import com.example.jyv_tool.Infraestructure.Repository.Rol.RolRepository;
import com.example.jyv_tool.Infraestructure.Repository.DetalleHerramienta.DetalleHerramientaRepository;
import com.example.jyv_tool.Infraestructure.Repository.FormaPago.FormaPagoRepository;
import com.example.jyv_tool.Infraestructure.Repository.HerramientaMantenimiento.HerramientaMantenimientoRepository;
import com.example.jyv_tool.Infraestructure.Repository.Localidad.LocalidadRepository;


@Service
public class EntidadesListarRepositoryImpl implements EntidadesListarService{

    private final RolRepository rolrepository;
    private final CategoriaRepository categoriarepository;
    private final DetalleFacturaRepository detalleFacturaReporitory;
    private final DetalleHerramientaRepository detalleHerramientaRepository;
    private final DetalleProveedorRepository detalleProveedorRepository ;
    private final EstadoRepository estadoRepository;
    private final FormaPagoRepository formaPagoRepository;
    private final HerramientaMantenimientoRepository herramientaMantenimientoRepository;
    private final LocalidadRepository localidadrepository;
    private final NotificacionesRepository notificacionesRepository;
    private final ReporteGeneralRepository reporteGeneralrepository;

    
    

    public EntidadesListarRepositoryImpl(RolRepository rolrepository, CategoriaRepository categoriarepository,
            DetalleFacturaRepository detalleFacturaReporitory,
            DetalleHerramientaRepository detalleHerramientaRepository,
            DetalleProveedorRepository detalleProveedorRepository, EstadoRepository estadoRepository,
            FormaPagoRepository formaPagoRepository,
            HerramientaMantenimientoRepository herramientaMantenimientoRepository,
            LocalidadRepository localidadrepository, NotificacionesRepository notificacionesRepository,
            ReporteGeneralRepository reporteGeneralrepository) {
        this.rolrepository = rolrepository;
        this.categoriarepository = categoriarepository;
        this.detalleFacturaReporitory = detalleFacturaReporitory;
        this.detalleHerramientaRepository = detalleHerramientaRepository;
        this.detalleProveedorRepository = detalleProveedorRepository;
        this.estadoRepository = estadoRepository;
        this.formaPagoRepository = formaPagoRepository;
        this.herramientaMantenimientoRepository = herramientaMantenimientoRepository;
        this.localidadrepository = localidadrepository;
        this.notificacionesRepository = notificacionesRepository;
        this.reporteGeneralrepository = reporteGeneralrepository;
    }

    @Override
    public List<Rol> findAllRol() {
        return rolrepository.findAll();
    }

    @Override
    public List<Localidad> findAllLocalidad() {
       return localidadrepository.findAll();
    }

    @Override
    public List<DetalleProveedor> findAllDP() {
        return detalleProveedorRepository.findAll();
    }

    @Override
    public List<ReporteGeneral> findAllRG() {
       return reporteGeneralrepository.findAll();
    }

    @Override
    public List<FormaPago> findAllFP() {
        return formaPagoRepository.findAll();
    }

    @Override
    public List<DetalleFactura> findAllDF() {
        return detalleFacturaReporitory.findAll();
    }

    @Override
    public List<Notificaciones> findAllNoti() {
        return notificacionesRepository.findAll();
    }

    @Override
    public List<Estado> findAllEstados() {
        return estadoRepository.findAll();
    }

    @Override
    public List<HerramientaMantenimiento> findAllHM() {
       return herramientaMantenimientoRepository.findAll();
    }

    @Override
    public List<Categoria> findAllCategorias() {
        return categoriarepository.findAll();
    }

    @Override
    public List<DetalleHerramienta> findAllDH() {
        return detalleHerramientaRepository.findAll();
    }


}
