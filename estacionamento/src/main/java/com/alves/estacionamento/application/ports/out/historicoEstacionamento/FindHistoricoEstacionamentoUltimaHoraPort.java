package com.alves.estacionamento.application.ports.out.historicoEstacionamento;

import com.alves.estacionamento.application.domain.models.HistoricoEstacionamento;

import java.util.List;

public interface FindHistoricoEstacionamentoUltimaHoraPort {

    List<HistoricoEstacionamento> find();
}
