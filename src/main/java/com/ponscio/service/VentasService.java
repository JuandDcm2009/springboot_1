package com.ponscio.service;

import java.util.List;

import com.ponscio.dto.request.VentasRequestDTO;
import com.ponscio.dto.response.VentasReponseDTO;

public interface VentasService {
    public VentasReponseDTO saveVenta(VentasRequestDTO dto);
    public List<VentasReponseDTO> listVentas();
    public VentasReponseDTO getVentaById(long id);
    public VentasReponseDTO updateVenta(long id, VentasRequestDTO dto);
    public void deleteVentaById(long id);
}
