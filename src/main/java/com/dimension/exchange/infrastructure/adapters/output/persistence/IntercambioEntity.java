package com.dimension.exchange.infrastructure.adapters.output.persistence;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="intercambio")
public class IntercambioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal monto;
    private String monedaOrigen;
    private String monedaDestino;
    private BigDecimal montoCambio;
    private BigDecimal tipoCambio;
}
