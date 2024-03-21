package com.alves.estacionamento.application.ports.in.historicoEstacionamento;

import com.alves.estacionamento.application.domain.models.HistoricoEstacionamento;

import java.util.List;

public interface FindHistoricoEstacionamentoUltimaHoraUseCase {

    List<HistoricoEstacionamento> find();
}
