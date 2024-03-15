package com.alves.estacionamento.application.domain.services.vagaestacionamento;

import com.alves.estacionamento.adapters.in.rest.data.request.EstabelecimentoRequest;
import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.domain.models.HistoricoEstacionamento;
import com.alves.estacionamento.application.domain.models.VagaEstacionamento;
import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.domain.models.enums.TipoVeiculo;
import com.alves.estacionamento.application.ports.in.estabelecimento.FindEstabelecimentoByIdUseCase;
import com.alves.estacionamento.application.ports.in.estabelecimento.UpdateEstabelecimentoUseCase;
import com.alves.estacionamento.application.ports.in.vagaestacionamento.SaveVagaEstacionamentoUseCase;
import com.alves.estacionamento.application.ports.in.veiculo.FindVeiculoByIdUseCase;
import com.alves.estacionamento.application.ports.out.historicoEstacionamento.SaveHistoricoEstabelecimentoPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;

@UseCase
@RequiredArgsConstructor
public class SaveVagaEstacionamentoService implements SaveVagaEstacionamentoUseCase {

    private final SaveHistoricoEstabelecimentoPort saveHistoricoEstabelecimentoPort;
    private final FindVeiculoByIdUseCase findVeiculoByIdUseCase;
    private final FindEstabelecimentoByIdUseCase findEstabelecimentoByIdUseCase;
    private final UpdateEstabelecimentoUseCase updateEstabelecimentoUseCase;

    public VagaEstacionamento save(VagaEstacionamento vagaEstacionamento) {
        Veiculo veiculo = findVeiculoByIdUseCase.find(vagaEstacionamento.getVeiculo().getId());
        Estabelecimento estabelecimento = findEstabelecimentoByIdUseCase.find(vagaEstacionamento.getEstabelecimento().getId());

        boolean temVaga = estaDisponivel(veiculo, estabelecimento);

        if (!temVaga) {
            throw new RuntimeException("Estacionamento cheio");
        }
        VagaEstacionamento newVaga = new VagaEstacionamento();
        newVaga.setVeiculo(veiculo);
        newVaga.setEstabelecimento(estabelecimento);

        estabelecimento.getVagasUsada().add(newVaga);

        HistoricoEstacionamento historicoEstacionamento = new HistoricoEstacionamento();
        historicoEstacionamento.setEstabelecimento(estabelecimento);
        historicoEstacionamento.setVeiculo(veiculo);

        saveHistoricoEstabelecimentoPort.save(historicoEstacionamento);

        updateEstabelecimentoUseCase.update(estabelecimento);

        return newVaga;
    }

    private Boolean estaDisponivel(Veiculo veiculo, Estabelecimento estabelecimento) {
        TipoVeiculo tipoVeiculo = veiculo.getTipoVeiculo();
        if (tipoVeiculo.equals(TipoVeiculo.MOTO)) {
            return estabelecimento.getTotalVagasMotos() >= estabelecimento.getVagasUsada()
                    .stream()
                    .filter(v -> v.getVeiculo().equals(tipoVeiculo))
                    .count()
                    ;
        } else if (tipoVeiculo.equals(TipoVeiculo.CARRO)) {
            return estabelecimento.getTotalVagasCarros() >= estabelecimento.getVagasUsada()
                    .stream()
                    .filter(v -> v.getVeiculo().equals(tipoVeiculo))
                    .count()
                    ;
        }
        throw new RuntimeException("erro inesperado");
    }
}
