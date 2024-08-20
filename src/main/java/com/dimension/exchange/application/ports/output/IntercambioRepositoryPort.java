package com.dimension.exchange.application.ports.output;

import com.dimension.exchange.domain.model.Intercambio;

import java.util.List;

public interface IntercambioRepositoryPort {

    Intercambio save(Intercambio intercambio);
    List<Intercambio> findAll();
}