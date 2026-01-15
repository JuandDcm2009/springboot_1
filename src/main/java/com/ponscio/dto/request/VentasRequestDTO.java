package com.ponscio.dto.request;

import java.math.BigDecimal;

public record VentasRequestDTO(String cedulaCliente, String cedulaVendedor, BigDecimal total) {
}
