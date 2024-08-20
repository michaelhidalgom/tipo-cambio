package com.dimension.exchange.application.ports.output;

import java.math.BigDecimal;

public interface TipoCambioPort {

    BigDecimal obtenerTasaCambio(String monedaOrigen, String monedaDestino);
}