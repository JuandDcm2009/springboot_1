package com.ponscio.service;

import java.util.List;

import com.ponscio.dto.request.DetalleVentaRequestDTO;
import com.ponscio.dto.response.DetalleVentaResponseDTO;
import com.ponscio.model.Producto;
import com.ponscio.model.Ventas;

public interface DetalleVentaService {
    public DetalleVentaResponseDTO createDetalleVenta(DetalleVentaRequestDTO dto, long productoId, long venta_id);    
    public List<DetalleVentaResponseDTO> listDetalleVenta();
    public DetalleVentaResponseDTO getDetalleVentaById(long id);
    public DetalleVentaResponseDTO updateDetalleVenta(long id, DetalleVentaRequestDTO dto);
    public void deleteDetalleVenta(long id);
}
