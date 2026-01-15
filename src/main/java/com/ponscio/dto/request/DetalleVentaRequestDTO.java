package com.ponscio.dto.request;

import java.math.BigDecimal;

public record DetalleVentaRequestDTO(long producto_id, Integer cantidad, long venta_id, BigDecimal subTotal) {
    
}

