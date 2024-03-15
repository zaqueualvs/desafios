package com.alves.estacionamento.adapters.out.persistence.h2.repositories;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.EstabelecimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<EstabelecimentoEntity, Long> {
}
