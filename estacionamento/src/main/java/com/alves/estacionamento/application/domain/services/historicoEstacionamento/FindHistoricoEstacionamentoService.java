package com.alves.estacionamento.application.domain.services.historicoEstacionamento;

import com.alves.estacionamento.application.domain.exceptions.EntidadeNaoEncontradaException;
import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.domain.models.HistoricoEstacionamento;
import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.in.historicoEstacionamento.FindHistoricoEstacionamentoUseCase;
import com.alves.estacionamento.application.ports.out.historicoEstacionamento.FindHistoricoEstacionamentoPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;

@UseCase
@RequiredArgsConstructor
public class FindHistoricoEstacionamentoService implements FindHistoricoEstacionamentoUseCase {

    private final FindHistoricoEstacionamentoPort findHistoricoEstacionamentoPort;

    @Override
    public HistoricoEstacionamento find(OffsetDateTime dateTime, Veiculo veiculo, Estabelecimento estabelecimento) {
        return findHistoricoEstacionamentoPort.find(dateTime, veiculo, estabelecimento)
                .orElseThrow(
                        () -> new EntidadeNaoEncontradaException("Não existe um historico de estacionamento")
                );
    }
}
