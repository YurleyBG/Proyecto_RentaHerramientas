package com.example.jyv_tool.Application.Service;

import java.util.List;

import com.example.jyv_tool.Domain.Dto.ReserveRequest;
import com.example.jyv_tool.Domain.Dto.ResponseReserve;
import com.example.jyv_tool.Domain.Entity.Reserva;

public interface ReservaService {

    List<Reserva>findAllReserve();
    boolean deleteReserve(Long id);
    ResponseReserve createNewReserve(ReserveRequest newReserve );
    ResponseReserve UpdateReserve(Long id ,ReserveRequest Reserve);

}
