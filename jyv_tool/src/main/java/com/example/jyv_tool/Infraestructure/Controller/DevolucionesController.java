package com.example.jyv_tool.Infraestructure.Controller;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jyv_tool.Application.Service.DevolucionesService;
import com.example.jyv_tool.Domain.Dto.Devoluciones.DevolucionesRequest;
import com.example.jyv_tool.Domain.Dto.Devoluciones.ResponseDevoluciones;
import com.example.jyv_tool.Domain.Entity.Devoluciones;

@RestController
@RequestMapping(value="/Api" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class DevolucionesController {

    
    private final DevolucionesService devolucionesService;

    public DevolucionesController(@Lazy DevolucionesService devolucionesService) {
        this.devolucionesService = devolucionesService;
    }

    @GetMapping("/devoluciones")
    public List<Devoluciones> findAll() {
        List<Devoluciones> DevolucionesResult= devolucionesService.findAllDevoluciones();
        return DevolucionesResult;
    }
   
    @PostMapping("/devoluciones")
    public ResponseEntity<ResponseDevoluciones> createNewDevoluciones(@RequestBody DevolucionesRequest newDevoluciones) {
        return new ResponseEntity<>(
            devolucionesService.createNewDevoluciones(newDevoluciones),
            HttpStatus.valueOf(200)
        );
    }
}
