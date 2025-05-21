package com.example.jyv_tool.Infraestructure.Controller;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jyv_tool.Application.Service.AlquilerService;
import com.example.jyv_tool.Domain.Dto.Alquiler.AlquilerRequest;
import com.example.jyv_tool.Domain.Dto.Alquiler.ResponseAlquilar;
import com.example.jyv_tool.Domain.Entity.Alquiler;

@RestController
@RequestMapping(value="/Api" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class AlquilerController {

    
    private final AlquilerService alquilerService;

    public AlquilerController(@Lazy AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @GetMapping("/alquiler")
    public List<Alquiler> findAll() {
        List<Alquiler> ReserveResult= alquilerService.findAllAlquiler();
        return ReserveResult;
    }
    @DeleteMapping("/alquiler/{id}")
    public ResponseEntity<?> DeleteAlquiler(@PathVariable Long id){

        boolean deletealquiler= alquilerService.deleteAlquiler(id);
        if (deletealquiler) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
        }
    }
    @PostMapping("/alquiler")
    public ResponseEntity<ResponseAlquilar> createNewAlquiler (@RequestBody AlquilerRequest newAlquiler) {
        return new ResponseEntity<>(
            alquilerService.createNewAlquiler(newAlquiler),
            HttpStatus.valueOf(200)
        );
    }

    @PatchMapping("/alquiler/{id}")
    public ResponseEntity<ResponseAlquilar> UpdateAlquileres(@PathVariable Long id,@RequestBody AlquilerRequest Alquiler ){
        return ResponseEntity.ok().body(alquilerService.UpdateAlquiler(id, Alquiler));
    }

}
