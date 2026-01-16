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

import com.ponscio.dto.request.ProductoRequestDTO;
import com.ponscio.dto.response.ProductoResponseDTO;
import com.ponscio.service.ProductosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductosService productosService;

    @PostMapping(path = "/crear")
    public ResponseEntity<ProductoResponseDTO> createProducto(@RequestBody ProductoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productosService.saveProducto(dto));
    }

    @GetMapping(path = "/listar")
    public ResponseEntity<List<ProductoResponseDTO>> listProductos() {
        return ResponseEntity.ok(productosService.listProductos());
    }

    @GetMapping(path = "/obtener/{id}")
    public ResponseEntity<ProductoResponseDTO> getById(@PathVariable("id") long id) {
        return ResponseEntity.ok(productosService.getProductoById(id));
    }

    @PutMapping(path = "/actualizar/{id}")
    public ResponseEntity<ProductoResponseDTO> updateById(@PathVariable long id, @RequestBody ProductoRequestDTO dto) {
        return ResponseEntity.ok(productosService.updateProducto(id, dto));
    }

    @DeleteMapping(path = "/eliminar/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        productosService.deleteProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
