package com.dimension.exchange.application.ports.input;

import com.dimension.exchange.domain.model.Intercambio;
import com.dimension.exchange.domain.model.IntercambioRequest;

import java.util.List;

public interface IntercambioUseCase {

    Intercambio procesarCambio(IntercambioRequest request);
    List<Intercambio> obtenerIntercambios();
}
