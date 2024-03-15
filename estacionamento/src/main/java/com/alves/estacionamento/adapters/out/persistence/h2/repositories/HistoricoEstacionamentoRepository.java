package com.alves.estacionamento.adapters.out.persistence.h2.repositories;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.EstabelecimentoEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.entities.HistoricoEstacionamentoEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.Optional;

public interface HistoricoEstacionamentoRepository extends JpaRepository<HistoricoEstacionamentoEntity, Long> {

    Optional<HistoricoEstacionamentoEntity> findByDataEntradaAndAndVeiculoAndEstabelecimento(OffsetDateTime dateTime, VeiculoEntity veiculo, EstabelecimentoEntity estabelecimento);
}
