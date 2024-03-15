package com.alves.estacionamento.adapters.out.persistence.h2.repositories;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Long> {
}
