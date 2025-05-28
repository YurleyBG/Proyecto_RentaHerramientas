package com.example.jyv_tool.Infraestructure.RepositoryImpl.Herramienta;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.jyv_tool.Application.Service.HerramientaService;
import com.example.jyv_tool.Domain.Dto.Herramienta.HerramientaRequest;
import com.example.jyv_tool.Domain.Dto.Herramienta.ResponseHerramientas;
import com.example.jyv_tool.Domain.Entity.Categoria;
import com.example.jyv_tool.Domain.Entity.DetalleHerramienta;
import com.example.jyv_tool.Domain.Entity.Herramienta;
import com.example.jyv_tool.Domain.Entity.Inventario;
import com.example.jyv_tool.Domain.Entity.Usuario;

import org.springframework.context.annotation.Lazy;

import com.example.jyv_tool.Infraestructure.Repository.Herramienta.HerramientaRepository;
import com.example.jyv_tool.Infraestructure.Repository.Inventario.InventarioRepository;
import com.example.jyv_tool.Infraestructure.Repository.Usuario.UsuarioRepository;
import com.example.jyv_tool.Infraestructure.Repository.Categoria.CategoriaRepository;

@Service
public class HerramientaRepositoryImpl implements HerramientaService   {
    
    private final HerramientaRepository herramientaRepository;
    private final CategoriaRepository categoriaRepository;
    private final InventarioRepository inventarioRepository;
    private final UsuarioRepository usuarioRepository;

    public HerramientaRepositoryImpl(@Lazy HerramientaRepository herramientaRepository,
    @Lazy CategoriaRepository categoriaRepository, @Lazy InventarioRepository inventarioRepository,@Lazy  UsuarioRepository usuarioRepository) {
        this.herramientaRepository = herramientaRepository;
        this.categoriaRepository=categoriaRepository;
        this.inventarioRepository=inventarioRepository;
        this.usuarioRepository=usuarioRepository;
    }
    
    @Override
    public List<Herramienta> findAllHerramienta() {
        return herramientaRepository.findAll();
    }

    @Override
    public boolean deleteHerramienta(Long id) {
        Optional<Herramienta> herraRemove =herramientaRepository.findById(id);
        if (herraRemove.isPresent()) {
            herramientaRepository.deleteById(id);
            return true;
        } 
        return false;
    }

    @Override
    public ResponseHerramientas createNewHerramienta(HerramientaRequest newHerramienta) {
        if (herramientaRepository.findByNombre(newHerramienta.getNombre()).isPresent()) {
            throw new DuplicateResourceException("Esta herramienta Ya existe : " + newHerramienta.getNombre());
        }
        String nombreProveedorUsuario = newHerramienta.getNombreProveedor();
        Usuario proveedorUsuario;
        if (nombreProveedorUsuario != null && !nombreProveedorUsuario.trim().isEmpty()) {
            proveedorUsuario = usuarioRepository.findByUsername(nombreProveedorUsuario)
                                .orElseThrow(() -> new ResourceNotFoundException("Proveedor no encontrado"));

            
            final String rol = "Proveedor";

            if (!proveedorUsuario.hasRole(rol)) {
                throw new IllegalArgumentException("el usuario no tiene este rol");
            }

        } else {
            throw new IllegalArgumentException("el nombre es obligatorio");
        }


        Herramienta HerramienticaNueva = new Herramienta();
        HerramienticaNueva.setNombre(newHerramienta.getNombre());
        HerramienticaNueva.setUrlImage(newHerramienta.getUrlImage());

        Long categoriaId = newHerramienta.getCategoriaId();

        if (categoriaId == null) {
            throw new IllegalArgumentException("no hay id Categoria");
        }
        Categoria categoriaObtenida = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada " + categoriaId));
        HerramienticaNueva.setCategoria(categoriaObtenida);

        if (newHerramienta.getMarca() != null ||
            newHerramienta.getDescripcion() != null ||
            newHerramienta.getModelo() != null ||
            newHerramienta.getPrecio_Diario() != null) {

            DetalleHerramienta detalles = new DetalleHerramienta();
            detalles.setMarca(newHerramienta.getMarca());
            detalles.setDescripcion(newHerramienta.getDescripcion());
            detalles.setModelo(newHerramienta.getModelo());
            detalles.setPrecio_Diario(newHerramienta.getPrecio_Diario());

            detalles.setHerramienta(HerramienticaNueva); 
            HerramienticaNueva.setDetalle(detalles);
        }
     
        if (newHerramienta.getFecha() != null) {
            Inventario inventario = new Inventario();
            inventario.setStock(newHerramienta.getStock());
            inventario.setFecha(newHerramienta.getFecha());
            inventario.setProveedorUsuario(proveedorUsuario);  
            Inventario savedInventario = inventarioRepository.save(inventario); 
                    
            HerramienticaNueva.setInventario(savedInventario);
        }

        Herramienta savedHerramienta = herramientaRepository.save(HerramienticaNueva);

        return mapToResponseHerramienta(savedHerramienta);  
    }

    private ResponseHerramientas mapToResponseHerramienta(Herramienta herramienta) {
        ResponseHerramientas response = new ResponseHerramientas();
        response.setId(herramienta.getId());
        response.setNombre(herramienta.getNombre());
        response.setUrlImage(herramienta.getUrlImage());

        if (herramienta.getCategoria() != null) {
            response.setCategoriaId(herramienta.getCategoria().getId());
        }

        if (herramienta.getDetalle() != null) {
            response.setMarca(herramienta.getDetalle().getMarca());
            response.setModelo(herramienta.getDetalle().getModelo());
            response.setPrecio_Diario(herramienta.getDetalle().getPrecio_Diario());
            response.setDescripcion(herramienta.getDetalle().getDescripcion());
        }

        if (herramienta.getInventario() !=null){
            response.setStock(herramienta.getInventario().getStock());
        }
        else{
            response.setStock(0);
        }
        
        return response;
       
    }

    @Override
    public ResponseHerramientas UpdateHerramienta(Long id, HerramientaRequest herramienta) {

        Herramienta siheramientica = herramientaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Herramienta no encontrada "));

         if (herramienta.getNombre() != null) {
            
            if (herramientaRepository.findByNombre(herramienta.getNombre()).isPresent() &&
                !herramientaRepository.findByNombre(herramienta.getNombre()).get().getId().equals(id)) {
                throw new DuplicateResourceException("Ya existe la herramienta ");
            }
            siheramientica.setNombre(herramienta.getNombre());
        }
        if (herramienta.getUrlImage() != null) {
            siheramientica.setUrlImage(herramienta.getUrlImage());
        }

        
        if (herramienta.getCategoriaId() != null &&(siheramientica.getCategoria() == null ||
            !herramienta.getCategoriaId().equals(siheramientica.getCategoria().getId()))) 
        {

            Categoria newCategoria = categoriaRepository.findById(herramienta.getCategoriaId())
            .orElseThrow(() -> new ResourceNotFoundException("Nueva categoría no encontrada "));
            siheramientica.setCategoria(newCategoria);
        }

        if (herramienta.getMarca() != null ||herramienta.getDescripcion() != null ||herramienta.getModelo() != null ||
            herramienta.getPrecio_Diario() != null) 
        {

            DetalleHerramienta detallitos = (DetalleHerramienta) siheramientica.getDetalle();

            if (detallitos == null) {
                detallitos = new DetalleHerramienta();
            }

            
            if (herramienta.getMarca() != null) {
                detallitos.setMarca(herramienta.getMarca());
            }
            if (herramienta.getDescripcion() != null) {
                detallitos.setDescripcion(herramienta.getDescripcion());
            }
            if (herramienta.getModelo() != null) {
                detallitos.setModelo(herramienta.getModelo());
            }
            if (herramienta.getPrecio_Diario() != null) {
                detallitos.setPrecio_Diario(herramienta.getPrecio_Diario());
            }
            siheramientica.setDetalle(detallitos);
        }
        Herramienta updatedHerramienta = herramientaRepository.save(siheramientica);

        return  mapToResponseHerramienta(updatedHerramienta);
    }

    @Override
    public List<Herramienta> searchHerramientas(String search) {
        return herramientaRepository.findByNombreContainingIgnoreCase(search);
    }

    @Override
    public Herramienta findHerramientaById(Long id) {
        return herramientaRepository.findById(id).orElse(null); 
    }

    @Override
    public List<Herramienta> findHerramientasByCategoria(String category) {
        return herramientaRepository.findByCategoria_NombreIgnoreCase(category);
    }

    @Override
    public List<Herramienta> findHerramientasDisponibles() {
        return herramientaRepository.findByInventario_StockGreaterThan(0);
    }

    

}
