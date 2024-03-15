package com.alves.estacionamento.application.domain.services.vagaestacionamento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.domain.models.HistoricoEstacionamento;
import com.alves.estacionamento.application.domain.models.VagaEstacionamento;
import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.in.estabelecimento.FindEstabelecimentoByIdUseCase;
import com.alves.estacionamento.application.ports.in.historicoEstacionamento.FindHistoricoEstacionamentoUseCase;
import com.alves.estacionamento.application.ports.in.vagaestacionamento.DeleteVagaEstacionamentoUseCase;
import com.alves.estacionamento.application.ports.in.veiculo.FindVeiculoByIdUseCase;
import com.alves.estacionamento.application.ports.out.estabelecimento.UpdateEstabelecimentoPort;
import com.alves.estacionamento.application.ports.out.historicoEstacionamento.UpdateHistoricoEstabelecimentoPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Objects;

@UseCase
@RequiredArgsConstructor
public class DeleteVagaEstacionamentoService implements DeleteVagaEstacionamentoUseCase {

    private final FindVeiculoByIdUseCase findVeiculoByIdUseCase;
    private final FindEstabelecimentoByIdUseCase findEstabelecimentoByIdUseCase;
    private final UpdateEstabelecimentoPort updateEstabelecimentoPort;
    private final UpdateHistoricoEstabelecimentoPort updateHistoricoEstabelecimentoPort;
    private final FindHistoricoEstacionamentoUseCase findHistoricoEstacionamentoUseCase;

    @Override
    public void delete(VagaEstacionamento vagaEstacionamento) {
        Long veiculoId = vagaEstacionamento.getVeiculo().getId();
        Long estabelecimentoId = vagaEstacionamento.getEstabelecimento().getId();
        Veiculo veiculo = findVeiculoByIdUseCase.find(veiculoId);
        Estabelecimento estabelecimento = findEstabelecimentoByIdUseCase.find(estabelecimentoId);

        vagaEstacionamento = estabelecimento.getVagasUsada()
                .stream()
                .filter(vaga -> Objects.equals(vaga.getVeiculo().getId(), veiculoId))
                .findFirst()
                .orElseThrow(
                        ()-> new RuntimeException("Veiculo não se encontra nesse estabelecimento")
                );

        HistoricoEstacionamento historicoEstacionamento = findHistoricoEstacionamentoUseCase
                .find(vagaEstacionamento.getDataEntrada(), veiculo, estabelecimento);

        estabelecimento.getVagasUsada().remove(vagaEstacionamento);
        updateEstabelecimentoPort.update(estabelecimento);
        historicoEstacionamento.setDataSaida(OffsetDateTime.now());
        updateHistoricoEstabelecimentoPort.update(historicoEstacionamento);
    }
}
