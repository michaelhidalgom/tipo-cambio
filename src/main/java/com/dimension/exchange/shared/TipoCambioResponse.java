package com.dimension.exchange.shared;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class TipoCambioResponse {

    //@JsonAlias("base_code")
    private String base_code;

    private Map<String, BigDecimal> rates;
}
