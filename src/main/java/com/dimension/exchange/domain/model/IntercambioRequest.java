package com.dimension.exchange.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class IntercambioRequest {

    private BigDecimal monto;
    private String monedaOrigen;
    private String monedaDestino;
}
