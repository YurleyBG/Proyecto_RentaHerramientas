package com.example.jyv_tool.Application.Service;

import java.util.List;

import com.example.jyv_tool.Domain.Dto.Alquiler.AlquilerRequest;
import com.example.jyv_tool.Domain.Dto.Alquiler.ResponseAlquilar;
import com.example.jyv_tool.Domain.Entity.Alquiler;

public interface AlquilerService {

    List<Alquiler>findAllAlquiler();
    boolean deleteAlquiler(Long id);
    ResponseAlquilar createNewAlquiler(AlquilerRequest newAlquiler );
    ResponseAlquilar UpdateAlquiler(Long id ,AlquilerRequest Alquiler);

}
