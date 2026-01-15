package com.ponscio.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ProductoRequestDTO(@NotBlank(message = "El hijueputa nombre no puede estar vacio") 
String nombre, 
String descripcion,
@Positive @Min(value = 1) Integer cantidad) {
    
}