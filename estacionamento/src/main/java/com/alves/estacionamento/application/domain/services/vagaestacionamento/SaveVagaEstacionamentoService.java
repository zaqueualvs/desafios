package com.alves.estacionamento.application.domain.services.vagaestacionamento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.domain.models.HistoricoEstacionamento;
import com.alves.estacionamento.application.domain.models.VagaEstacionamento;
import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.domain.models.enums.TipoVeiculo;
import com.alves.estacionamento.application.ports.in.estabelecimento.FindEstabelecimentoByIdUseCase;
import com.alves.estacionamento.application.ports.in.estabelecimento.UpdateEstabelecimentoUseCase;
import com.alves.estacionamento.application.ports.in.vagaestacionamento.SaveVagaEstacionamentoUseCase;
import com.alves.estacionamento.application.ports.in.veiculo.FindVeiculoByIdUseCase;
import com.alves.estacionamento.application.ports.out.historicoEstacionamento.SaveHistoricoEstacionamentoPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@UseCase
@RequiredArgsConstructor
public class SaveVagaEstacionamentoService implements SaveVagaEstacionamentoUseCase {

    private final SaveHistoricoEstacionamentoPort saveHistoricoEstabelecimentoPort;
    private final FindVeiculoByIdUseCase findVeiculoByIdUseCase;
    private final FindEstabelecimentoByIdUseCase findEstabelecimentoByIdUseCase;
    private final UpdateEstabelecimentoUseCase updateEstabelecimentoUseCase;

    @Transactional
    public VagaEstacionamento save(VagaEstacionamento vagaEstacionamento) {
        Long veiculoId = vagaEstacionamento.getVeiculo().getId();
        Veiculo veiculo = findVeiculoByIdUseCase.find(veiculoId);
        Estabelecimento estabelecimento = findEstabelecimentoByIdUseCase.find(vagaEstacionamento.getEstabelecimento().getId());

        estaDisponivel(veiculo.getTipoVeiculo(), estabelecimento);

        vagaEstacionamento.setVeiculo(veiculo);
        vagaEstacionamento.setEstabelecimento(estabelecimento);
        vagaEstacionamento.setDataEntrada(OffsetDateTime.now());

        jaEstaEstacionado(estabelecimento, vagaEstacionamento);

        estabelecimento.getVagasUsada().add(vagaEstacionamento);
        estabelecimento = updateEstabelecimentoUseCase.update(estabelecimento);

        HistoricoEstacionamento historicoEstacionamento = new HistoricoEstacionamento();
        historicoEstacionamento.setEstabelecimento(estabelecimento);
        historicoEstacionamento.setVeiculo(veiculo);
        historicoEstacionamento.setDataEntrada(vagaEstacionamento.getDataEntrada());

        saveHistoricoEstabelecimentoPort.save(historicoEstacionamento);
        updateEstabelecimentoUseCase.update(estabelecimento);

        return vagaEstacionamento;
    }

    private void estaDisponivel(TipoVeiculo tipoVeiculo, Estabelecimento estabelecimento) {
        boolean disponivel = false;
        long vagaUsada = estabelecimento.getVagasUsada()
                .stream()
                .filter(v -> v.getVeiculo().getTipoVeiculo().equals(tipoVeiculo))
                .count();

        if (tipoVeiculo.equals(TipoVeiculo.MOTO)) {
            disponivel = (vagaUsada < estabelecimento.getTotalVagasMotos());
        } else if (tipoVeiculo.equals(TipoVeiculo.CARRO)) {
            disponivel = (vagaUsada < estabelecimento.getTotalVagasCarros());
        }
        if (!disponivel) {
            throw new RuntimeException("Estacionamento cheio");
        }

    }

    private void jaEstaEstacionado(Estabelecimento estabelecimento, VagaEstacionamento vagaEstacionamento) {
        if (estabelecimento.getVagasUsada().contains(vagaEstacionamento)) {
            throw new RuntimeException(
                    String.format("Veiculo do tipo %s ja esta no estacionamento", vagaEstacionamento.getVeiculo().getTipoVeiculo())
            );
        }
    }
}
