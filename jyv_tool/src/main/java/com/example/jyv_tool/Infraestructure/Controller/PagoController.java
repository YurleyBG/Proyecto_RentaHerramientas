package com.example.jyv_tool.Infraestructure.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jyv_tool.Application.Service.PagoService;
import com.example.jyv_tool.Domain.Dto.Pago.PagoRequest;
import com.example.jyv_tool.Domain.Dto.Pago.ResponsePago;
import com.example.jyv_tool.Domain.Entity.Pago;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value="/Home" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class PagoController {

    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping("/pago")
    public List<Pago> findAll() {
        List<Pago> PagoResult= pagoService.findAllPago();
        return PagoResult;
    }
   
    @PostMapping("/pago")
    public ResponseEntity<ResponsePago> createNewPago(@RequestBody PagoRequest newPago) {
        return new ResponseEntity<>(
            pagoService.createNewpago(null),
            HttpStatus.valueOf(200)
        );
    }

    @PatchMapping("/pago/{id}")
    public ResponseEntity<ResponsePago> UpdatePago(@PathVariable Long id,@RequestBody PagoRequest pago ){
        return ResponseEntity.ok().body(pagoService.Updatepago(id,pago));
    }

}
