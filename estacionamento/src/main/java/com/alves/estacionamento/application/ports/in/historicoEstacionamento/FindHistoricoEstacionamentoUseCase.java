package com.alves.estacionamento.application.ports.in.historicoEstacionamento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.domain.models.HistoricoEstacionamento;
import com.alves.estacionamento.application.domain.models.Veiculo;

import java.time.OffsetDateTime;

public interface FindHistoricoEstacionamentoUseCase {

    HistoricoEstacionamento find(OffsetDateTime dateTime, Veiculo veiculo, Estabelecimento estabelecimento);
}
