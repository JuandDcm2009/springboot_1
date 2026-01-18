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

import com.ponscio.dto.request.VentasRequestDTO;
import com.ponscio.dto.response.VentasReponseDTO;
import com.ponscio.service.VentasService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentasController {
    private final VentasService ventasService;

    @PostMapping(path = "/crear")
    public ResponseEntity<VentasReponseDTO> createVentas(@RequestBody VentasRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ventasService.saveVenta(dto));
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<List<VentasReponseDTO>> listVentas() {
        return ResponseEntity.ok(ventasService.listVentas());
    }

    @GetMapping(path = "/obtener/{id}")
    public ResponseEntity<VentasReponseDTO> getVentaById(@PathVariable long id) {
        return ResponseEntity.ok(ventasService.getVentaById(id));
    }

    @PutMapping(path = "/actualizar/{id}")
    public ResponseEntity<VentasReponseDTO> updateVentaById(@PathVariable long id, @RequestBody VentasRequestDTO dto) {
        return ResponseEntity.ok(ventasService.updateVenta(id, dto));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        ventasService.deleteVentaById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
    }
}
