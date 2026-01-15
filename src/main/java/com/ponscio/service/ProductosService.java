package com.ponscio.service;

import java.util.List;

import com.ponscio.dto.request.ProductoRequestDTO;
import com.ponscio.dto.response.ProductoResponseDTO;

public interface ProductosService {
    public ProductoResponseDTO saveProducto(ProductoRequestDTO dto);
    public List<ProductoResponseDTO> listProductos();     
    public ProductoResponseDTO getProductoById(long id);
    public ProductoResponseDTO updateProducto(long id, ProductoRequestDTO dto);
    public void deleteProducto(long id);
}
