package com.ponscio.dto.response;

public record ProductoResponseDTO(
    long id,
    String nombre,
    String descripcion,
    Integer cantidad
) {
    
}
