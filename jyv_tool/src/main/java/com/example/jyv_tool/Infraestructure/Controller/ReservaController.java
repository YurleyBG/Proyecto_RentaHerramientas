package com.example.jyv_tool.Infraestructure.Controller;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jyv_tool.Domain.Dto.Reserva.ReserveRequest;
import com.example.jyv_tool.Domain.Dto.Reserva.ResponseReserve;
import com.example.jyv_tool.Application.Service.ReservaService;
import com.example.jyv_tool.Domain.Entity.Reserva;

@RestController
@RequestMapping(value="/Api" ,produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservaController {

   
    private final ReservaService reservaservice;

    public ReservaController(@Lazy ReservaService reservaservice) {
        this.reservaservice = reservaservice;
    }

    @GetMapping("/reserva")
    public List<Reserva> findAll() {
        List<Reserva> ReserveResult= reservaservice.findAllReserve();
        return ReserveResult;
    }
    @PostMapping("/reserva")
    public ResponseEntity<ResponseReserve> createNewReserve(@RequestBody ReserveRequest newReserve) {
        return new ResponseEntity<>(
            reservaservice.createNewReserve(newReserve),
            HttpStatus.valueOf(200)
        );
    }
    @PatchMapping("/reserva/{id}")
    public ResponseEntity<ResponseReserve> UpdateReserve(@PathVariable Long id,@RequestBody ReserveRequest Reserve ){

        return ResponseEntity.ok().body(reservaservice.UpdateReserve(id,Reserve));
    }


}
