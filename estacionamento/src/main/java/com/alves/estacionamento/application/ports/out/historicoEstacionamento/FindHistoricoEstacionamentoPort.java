package com.alves.estacionamento.application.ports.out.historicoEstacionamento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.domain.models.HistoricoEstacionamento;
import com.alves.estacionamento.application.domain.models.Veiculo;

import java.time.OffsetDateTime;
import java.util.Optional;

public interface FindHistoricoEstacionamentoPort {

    Optional<HistoricoEstacionamento> find(OffsetDateTime dateTime, Veiculo veiculo, Estabelecimento estabelecimento);
}
