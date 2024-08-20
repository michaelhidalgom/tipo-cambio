package com.dimension.exchange.infrastructure.adapters.output.persistence;

import com.dimension.exchange.application.ports.output.IntercambioRepositoryPort;
import com.dimension.exchange.domain.model.Intercambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IntercambioRepositoryAdapter implements IntercambioRepositoryPort {

    @Autowired
    private JpaIntercambioRepository jpaIntercambioRepository;

    @Override
    public Intercambio save(Intercambio intercambio) {

        IntercambioEntity intercambioEntity = mapToEntity(intercambio);
        IntercambioEntity saveEntity = jpaIntercambioRepository.save(intercambioEntity);

        return mapToDomain(saveEntity);
    }

    @Override
    public List<Intercambio> findAll() {

        List<IntercambioEntity> intercambioEntities = jpaIntercambioRepository.findAll();

        return intercambioEntities.stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    private IntercambioEntity mapToEntity(Intercambio intercambio) {

        System.out.println(intercambio.toString());

        IntercambioEntity intercambioEntity = new IntercambioEntity();

        intercambioEntity.setTipoCambio(intercambio.getTipoCambio());
        intercambioEntity.setMonedaOrigen(intercambio.getMonedaOrigen());
        intercambioEntity.setMonedaDestino(intercambio.getMonedaDestino());
        intercambioEntity.setMonto(intercambio.getMonto());
        intercambioEntity.setMontoCambio(intercambio.getMontoCambio());


        System.out.println(intercambioEntity.toString());

        return intercambioEntity;
    }

    private Intercambio mapToDomain(IntercambioEntity intercambioEntity) {

        Intercambio intercambio = new Intercambio();

        intercambio.setId(intercambioEntity.getId());
        intercambio.setTipoCambio(intercambioEntity.getTipoCambio());
        intercambio.setMonedaOrigen(intercambioEntity.getMonedaOrigen());
        intercambio.setMonedaDestino(intercambioEntity.getMonedaDestino());
        intercambio.setMonto(intercambioEntity.getMonto());
        intercambio.setMontoCambio(intercambioEntity.getMontoCambio());

        return intercambio;
    }

}
