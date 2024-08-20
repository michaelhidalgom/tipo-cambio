package com.dimension.exchange.infrastructure.adapters.output.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaIntercambioRepository extends JpaRepository<IntercambioEntity, Long> {
}