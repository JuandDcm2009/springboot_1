package com.ponscio.dto.response;

import java.math.BigDecimal;

public record VentasReponseDTO(
    long id,
    String cedulaCliente,
    String cedulaVendedor,
    BigDecimal total
) {
    
}
