package com.dimension.exchange.infrastructure.adapters.input.rest;

import com.dimension.exchange.application.ports.input.IntercambioUseCase;
import com.dimension.exchange.domain.model.Intercambio;
import com.dimension.exchange.domain.model.IntercambioRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/intercambios")
public class IntercambioController {

    private final IntercambioUseCase intercambioUseCase;

    public IntercambioController(IntercambioUseCase intercambioUseCase) {
        this.intercambioUseCase = intercambioUseCase;
    }

    @PostMapping("/procesa")
    public Intercambio procesarCambio(@RequestBody IntercambioRequest request) {

        return intercambioUseCase.procesarCambio(request);
    }

    @GetMapping
    public List<Intercambio> obtenerIntercambios() {
        return intercambioUseCase.obtenerIntercambios();
    }
}