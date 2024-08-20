package com.dimension.exchange.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Intercambio {

    private Long id;
    private BigDecimal monto;
    private  String monedaOrigen;
    private  String monedaDestino;
    private  BigDecimal montoCambio;
    private  BigDecimal tipoCambio;
}
