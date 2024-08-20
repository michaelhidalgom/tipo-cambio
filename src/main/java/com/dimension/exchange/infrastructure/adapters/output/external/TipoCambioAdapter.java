package com.dimension.exchange.infrastructure.adapters.output.external;

import com.dimension.exchange.application.ports.output.TipoCambioPort;
import com.dimension.exchange.shared.TipoCambioResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TipoCambioAdapter implements TipoCambioPort {

    private final TipoCambioClient tipoCambioClient;

    public TipoCambioAdapter(TipoCambioClient tipoCambioClient) {
        this.tipoCambioClient = tipoCambioClient;
    }

    @Override
    public BigDecimal obtenerTasaCambio(String monedaOrigen, String monedaDestino) {

        TipoCambioResponse tipoCambioResponse = tipoCambioClient.getTipoCambio(monedaOrigen);
        BigDecimal tasaIntercambio = tipoCambioResponse.getRates().get(monedaDestino);

        return tasaIntercambio;
    }
}