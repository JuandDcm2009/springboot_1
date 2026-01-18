package com.ponscio.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ponscio.dto.request.DetalleVentaRequestDTO;
import com.ponscio.dto.response.DetalleVentaResponseDTO;
import com.ponscio.service.DetalleVentaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/detalleVenta")
@RequiredArgsConstructor
public class DetalleVentaController {
    public final DetalleVentaService detalleVentaService;

    @PostMapping(path = "/crear")
    public ResponseEntity<DetalleVentaResponseDTO> createDetalleVenta(@RequestBody DetalleVentaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleVentaService.createDetalleVenta(dto, dto.producto_id(), dto.venta_id()));
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<List<DetalleVentaResponseDTO>> listDetalleVenta() {
        return ResponseEntity.ok(detalleVentaService.listDetalleVenta());
    }

    @GetMapping(path = "/obtener/{id}")
    public ResponseEntity<DetalleVentaResponseDTO> getDetalleVentaById(@PathVariable long id) {
        return ResponseEntity.ok(detalleVentaService.getDetalleVentaById(id));
    }

    @PutMapping(path = "/actualizar/{id}")
    public ResponseEntity<DetalleVentaResponseDTO> updateDetalleVenta(@PathVariable long id,@RequestBody DetalleVentaRequestDTO dto) {
        return ResponseEntity.ok(detalleVentaService.updateDetalleVenta(id, dto));
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<Void> deleteDetalleVenta(@PathVariable long id) {
        detalleVentaService.deleteDetalleVenta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
