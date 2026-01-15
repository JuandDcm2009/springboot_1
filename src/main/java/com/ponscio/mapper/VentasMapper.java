package com.ponscio.mapper;

import org.springframework.stereotype.Component;

import com.ponscio.dto.request.VentasRequestDTO;
import com.ponscio.dto.response.VentasReponseDTO;
import com.ponscio.model.Ventas;

@Component
public class VentasMapper {
    
    public VentasReponseDTO ventasToDTO(Ventas ventas) {
        if (ventas == null) return null;
        return new VentasReponseDTO(
            ventas.getId(),
            ventas.getCedulaCliente(),
            ventas.getCedulaVendedor(),
            ventas.getTotal()
        );
    }

    public Ventas DTOToVentas(VentasRequestDTO dto) {
        if (dto == null) return null;
        Ventas v = new Ventas();
        v.setCedulaCliente(dto.cedulaCliente());
        v.setCedulaVendedor(dto.cedulaVendedor());
        v.setTotal(dto.total());
        return v;
    }

    public void updateVentasFromDTO(Ventas venta, VentasRequestDTO dto) {
        if (dto == null) return;
        venta.setCedulaCliente(dto.cedulaCliente());
        venta.setCedulaVendedor(dto.cedulaVendedor());
        venta.setTotal(dto.total());
    }
}
