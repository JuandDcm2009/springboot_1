package com.ponscio.mapper;

import org.springframework.stereotype.Component;

import com.ponscio.dto.request.DetalleVentaRequestDTO;
import com.ponscio.dto.response.DetalleVentaResponseDTO;
import com.ponscio.model.DetalleVenta;
import com.ponscio.model.Producto;
import com.ponscio.model.Ventas;

@Component
public class DetalleVentaMapper {  
    public DetalleVentaResponseDTO detalleVentaToDTO(DetalleVenta dv) {
        if (dv == null) return null;
        return new DetalleVentaResponseDTO(
            dv.getId(),
            dv.getProducto()!=null?dv.getProducto().getId():null,
            dv.getCantidad(),
            dv.getVentas()!=null?dv.getVentas().getId():null,
            dv.getSubTotal()
        );
    }

    public DetalleVenta DTOToDetalleVenta(DetalleVentaRequestDTO dto, Producto producto, Ventas ventas) {
        if (dto == null) return null;
        DetalleVenta dv = new DetalleVenta();
        dv.setProducto(producto);
        dv.setCantidad(dto.cantidad());
        dv.setVentas(ventas);
        dv.setSubTotal(dto.subTotal());
        return dv;
    }

    public void updateDetalleVentaFromDTO(DetalleVenta dv, DetalleVentaRequestDTO dto, Producto producto, Ventas ventas) {
        if (dto == null) return;
        
        dv.setProducto(producto);
        dv.setCantidad(dto.cantidad());
        dv.setVentas(ventas);
        dv.setSubTotal(dto.subTotal());
    }
}
