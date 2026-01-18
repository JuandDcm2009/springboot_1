package com.ponscio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ponscio.dto.request.VentasRequestDTO;
import com.ponscio.dto.response.VentasReponseDTO;
import com.ponscio.mapper.VentasMapper;
import com.ponscio.model.Ventas;
import com.ponscio.repository.VentasRepository;
import com.ponscio.service.VentasService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VentasServiceImpl implements VentasService{

    private final VentasRepository ventasRepository;
    private final VentasMapper ventasMapper;

    @Override
    public VentasReponseDTO saveVenta(VentasRequestDTO dto) {
        Ventas venta = ventasRepository.save(ventasMapper.DTOToVentas(dto));
        return ventasMapper.ventasToDTO(venta);
    }

    @Override
    public List<VentasReponseDTO> listVentas() {
        return ventasRepository.findAll().stream().map(ventasMapper::ventasToDTO).toList();
    }

    @Override
    public VentasReponseDTO getVentaById(long id) {
        Ventas venta = ventasRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la venta"));
        return ventasMapper.ventasToDTO(venta);
    }

    @Override
    public VentasReponseDTO updateVenta(long id, VentasRequestDTO dto) {
        Ventas venta = ventasRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la venta"));
        ventasMapper.updateVentasFromDTO(venta, dto);
        return ventasMapper.ventasToDTO(ventasRepository.save(venta));
    }

    @Override
    public void deleteVentaById(long id) {
        ventasRepository.deleteById(id);
    }
    
}
