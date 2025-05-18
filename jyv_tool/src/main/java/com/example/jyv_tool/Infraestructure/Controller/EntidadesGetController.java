package com.example.jyv_tool.Infraestructure.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jyv_tool.Application.Service.EntidadesListarService;
import com.example.jyv_tool.Domain.Entity.Categoria;

import java.util.List;

import org.springframework.http.MediaType;

@RestController
@RequestMapping(value="/Home" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class EntidadesGetController {

    private final EntidadesListarService entidadesGetService;

    public EntidadesGetController(EntidadesListarService entidadesGetService) {
        this.entidadesGetService = entidadesGetService;
    }

    @GetMapping("/categoria")
    public List<Categoria> findAll() {
        List<Categoria> CateResult = entidadesGetService.findAllCategorias();
        return CateResult;
    }


}
