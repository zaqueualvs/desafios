package com.alves.estacionamento.application.ports.out.historicoEstacionamento;

import com.alves.estacionamento.application.domain.models.HistoricoEstacionamento;

public interface UpdateHistoricoEstabelecimentoPort {

    HistoricoEstacionamento update(HistoricoEstacionamento historicoEstacionamento);
}
