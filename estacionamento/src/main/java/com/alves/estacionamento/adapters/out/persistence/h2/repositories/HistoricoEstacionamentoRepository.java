package com.alves.estacionamento.adapters.out.persistence.h2.repositories;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.HistoricoEstacionamentoEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.entities.VagaEstacionamentoPKEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoricoEstacionamentoRepository extends JpaRepository<HistoricoEstacionamentoEntity, VagaEstacionamentoPKEntity> {
}
