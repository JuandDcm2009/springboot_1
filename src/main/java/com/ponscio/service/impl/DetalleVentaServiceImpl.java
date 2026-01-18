package com.ponscio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ponscio.dto.request.DetalleVentaRequestDTO;
import com.ponscio.dto.response.DetalleVentaResponseDTO;
import com.ponscio.mapper.DetalleVentaMapper;
import com.ponscio.model.DetalleVenta;
import com.ponscio.model.Producto;
import com.ponscio.model.Ventas;
import com.ponscio.repository.DetalleVentaRepository;
import com.ponscio.repository.ProductoRepository;
import com.ponscio.repository.VentasRepository;
import com.ponscio.service.DetalleVentaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetalleVentaServiceImpl implements DetalleVentaService{
    private final DetalleVentaRepository detalleVentaRepository;
    private final ProductoRepository productoRepository;
    private final VentasRepository ventasRepository;
    private final DetalleVentaMapper detalleVentaMapper;

    @Override
    public DetalleVentaResponseDTO createDetalleVenta(DetalleVentaRequestDTO dto, long producto_id, long venta_id) {
        Producto producto = productoRepository.findById(producto_id).orElseThrow(
            () -> new RuntimeException("No se logro encontrar el producto"));
        Ventas venta = ventasRepository.findById(venta_id).orElseThrow(
            () -> new RuntimeException("No se logro encontrar la venta"));
        DetalleVenta detalleVenta = detalleVentaMapper.DTOToDetalleVenta(dto, producto, venta);
        return detalleVentaMapper.detalleVentaToDTO(detalleVentaRepository.save(detalleVenta));
    }

    @Override
    public List<DetalleVentaResponseDTO> listDetalleVenta() {
        return detalleVentaRepository.findAll().stream().map(detalleVentaMapper::detalleVentaToDTO).toList();
    }

    @Override
    public DetalleVentaResponseDTO getDetalleVentaById(long id) {
        DetalleVenta detalleVenta = detalleVentaRepository.findById(id).orElseThrow(
            () -> new RuntimeException("No se pudo encontrar el Detalle de venta"));
        return detalleVentaMapper.detalleVentaToDTO(detalleVenta);
    }

    @Override
    public DetalleVentaResponseDTO updateDetalleVenta(long id, DetalleVentaRequestDTO dto) {
        DetalleVenta detalleVenta = detalleVentaRepository.findById(id).orElseThrow(
            () -> new RuntimeException("No se pudo encontrar el Detalle de venta"));
        Producto producto = productoRepository.findById(dto.producto_id()).orElseThrow(
            () -> new RuntimeException("No se logro encontrar el producto"));
        Ventas venta = ventasRepository.findById(dto.venta_id()).orElseThrow(
            () -> new RuntimeException("No se logro encontrar la venta"));
        detalleVentaMapper.updateDetalleVentaFromDTO(detalleVenta, dto, producto, venta);
        return detalleVentaMapper.detalleVentaToDTO(detalleVentaRepository.save(detalleVenta));
    }

    @Override
    public void deleteDetalleVenta(long id) {
        detalleVentaRepository.deleteById(id);
    }
    
}
