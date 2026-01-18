package com.ponscio.service.impl;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.ponscio.dto.request.ProductoRequestDTO;
import com.ponscio.dto.response.ProductoResponseDTO;
import com.ponscio.mapper.ProductosMapper;
import com.ponscio.model.Producto;
import com.ponscio.repository.ProductoRepository;
import com.ponscio.service.ProductosService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor // Inyecion de dependencias por constructor
public class ProductosServiceImpl implements ProductosService{

    private final ProductoRepository productoRepository;
    private final ProductosMapper productosMapper;

    @Override
    public ProductoResponseDTO saveProducto(ProductoRequestDTO dto) {
        Producto producto = productosMapper.DTOToProduct(dto);
        return productosMapper.entityToDTO(productoRepository.save(producto));
    }

    @Override
    public List<ProductoResponseDTO> listProductos() {
        return productoRepository.findAll().stream().map(productosMapper::entityToDTO).toList();
    }

    @Override
    public ProductoResponseDTO getProductoById(long id) {
        Producto productos = productoRepository.findById(id).orElseThrow(
            () -> new RuntimeException("No se encontro el producto"));
        return productosMapper.entityToDTO(productos);
    }

    @Override
    public ProductoResponseDTO updateProducto(long id, ProductoRequestDTO dto) {
        Producto productos = productoRepository.findById(id).orElseThrow(
            () -> new RuntimeException("No se encontro el producto"));
        productosMapper.updateEntityFromDTO(productos, dto);
        return productosMapper.entityToDTO(productoRepository.save(productos));
    }

    @Override
    public void deleteProducto(long id) {
        productoRepository.deleteById(id);
    }
    
}
