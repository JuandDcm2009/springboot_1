package com.ponscio.mapper;

import org.springframework.stereotype.Component;

import com.ponscio.dto.request.ProductoRequestDTO;
import com.ponscio.dto.response.ProductoResponseDTO;
import com.ponscio.model.Producto;

@Component
public class ProductosMapper {
    public ProductoResponseDTO entityToDTO(Producto producto) {
        if (producto == null) return null;
        return new ProductoResponseDTO(
            producto.getId(),
            producto.getNombre(),
            producto.getDescripcion(),
            producto.getCantidad()
        );
    }

    public Producto DTOToProduct(ProductoRequestDTO productoRequest) {
        if (productoRequest == null) return null;
        Producto p = new Producto();
        p.setNombre(productoRequest.nombre());
        p.setDescripcion(productoRequest.descripcion());
        p.setCantidad(productoRequest.cantidad());

        return p;
    }

    public void updateEntityFromDTO(Producto p, ProductoRequestDTO dto) {
        if (dto == null) return;
        p.setNombre(dto.nombre());
        p.setDescripcion(dto.descripcion());
        p.setCantidad(dto.cantidad());
    }
}
