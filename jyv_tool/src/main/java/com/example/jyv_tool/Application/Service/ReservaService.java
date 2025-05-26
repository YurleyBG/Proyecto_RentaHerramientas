package com.example.jyv_tool.Application.Service;

import java.util.List;

import com.example.jyv_tool.Domain.Dto.Reserva.ReserveRequest;
import com.example.jyv_tool.Domain.Dto.Reserva.ResponseReserve;
import com.example.jyv_tool.Domain.Entity.Reserva;

public interface ReservaService {

    List<Reserva>findAllReserve();
    ResponseReserve createNewReserve(ReserveRequest newReserve );
    ResponseReserve UpdateReserve(Long id ,ReserveRequest Reserve);

}
