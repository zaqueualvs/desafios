package com.alves.estacionamento.adapters.out.persistence.h2.adapters.historicoEstacionamento;

import com.alves.estacionamento.application.domain.models.HistoricoEstacionamento;
import com.alves.estacionamento.application.ports.out.historicoEstacionamento.SaveHistoricoEstacionamentoPort;
import com.alves.estacionamento.application.ports.out.historicoEstacionamento.UpdateHistoricoEstabelecimentoPort;
import com.alves.estacionamento.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class UpdateHistoricoEstabelecimentoPersistenceAdapter implements UpdateHistoricoEstabelecimentoPort {

    private final SaveHistoricoEstacionamentoPort saveHistoricoEstabelecimentoPort;

    @Override
    public HistoricoEstacionamento update(HistoricoEstacionamento historicoEstacionamento) {
        return saveHistoricoEstabelecimentoPort.save(historicoEstacionamento);
    }
}
