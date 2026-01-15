package com.ponscio.dto.response;

import java.math.BigDecimal;

public record DetalleVentaResponseDTO(
    long id,
    long producto_id,
    Integer cantidad,
    long venta_id,
    BigDecimal subTotal
) {
    
}
