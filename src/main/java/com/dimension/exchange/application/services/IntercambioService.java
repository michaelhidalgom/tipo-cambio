package com.dimension.exchange.application.services;

import com.dimension.exchange.application.ports.input.IntercambioUseCase;
import com.dimension.exchange.application.ports.output.IntercambioRepositoryPort;
import com.dimension.exchange.application.ports.output.TipoCambioPort;
import com.dimension.exchange.domain.model.Intercambio;
import com.dimension.exchange.domain.model.IntercambioRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IntercambioService implements IntercambioUseCase {

    private final IntercambioRepositoryPort intercambioRepositoryPort;
    private final TipoCambioPort tipoCambioPort;

    public IntercambioService(IntercambioRepositoryPort intercambioRepositoryPort, TipoCambioPort tipoCambioPort) {
        this.intercambioRepositoryPort = intercambioRepositoryPort;
        this.tipoCambioPort = tipoCambioPort;
    }

    @Override
    public Intercambio procesarCambio(IntercambioRequest request) {

        String monedaOrigen = request.getMonedaOrigen();
        String monedaDestino = request.getMonedaDestino();
        BigDecimal tasaIntercambio = tipoCambioPort.obtenerTasaCambio(request.getMonedaOrigen(),request.getMonedaDestino());
        BigDecimal montoCambio = request.getMonto().multiply(tasaIntercambio);

        //setear datos de intercambio
        Intercambio intercambio = new Intercambio();
        intercambio.setTipoCambio(tasaIntercambio);
        intercambio.setMonedaOrigen(monedaOrigen);
        intercambio.setMonedaDestino(monedaDestino);
        intercambio.setMonto(request.getMonto());
        intercambio.setMontoCambio(montoCambio);

        //guarda la informacion
        Intercambio saveIntercambio = intercambioRepositoryPort.save(intercambio);

        return  saveIntercambio;
    }

    @Override
    public List<Intercambio> obtenerIntercambios() {

        return intercambioRepositoryPort.findAll();
    }
}