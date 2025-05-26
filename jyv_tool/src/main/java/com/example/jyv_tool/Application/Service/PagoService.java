package com.example.jyv_tool.Application.Service;

import java.util.List;

import com.example.jyv_tool.Domain.Dto.Pago.PagoRequest;
import com.example.jyv_tool.Domain.Dto.Pago.ResponsePago;
import com.example.jyv_tool.Domain.Entity.Pago;

public interface PagoService {

    List<Pago>findAllPago();
    ResponsePago createNewpago(PagoRequest newpago );
    ResponsePago Updatepago(Long id ,PagoRequest pago);

}
