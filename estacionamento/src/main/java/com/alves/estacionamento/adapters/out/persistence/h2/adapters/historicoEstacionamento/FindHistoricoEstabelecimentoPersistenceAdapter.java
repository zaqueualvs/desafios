package com.alves.estacionamento.adapters.out.persistence.h2.adapters.historicoEstacionamento;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.EstabelecimentoEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.entities.HistoricoEstacionamentoEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.entities.VeiculoEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.CycleAvoidingMappingContext;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.EstabelecimentoPersistenceMapper;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.HistoricoEstacionamentoPersistenceMapper;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.VeiculoPersistenceMapper;
import com.alves.estacionamento.adapters.out.persistence.h2.repositories.HistoricoEstacionamentoRepository;
import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.domain.models.HistoricoEstacionamento;
import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.out.historicoEstacionamento.FindHistoricoEstacionamentoPort;
import com.alves.estacionamento.application.ports.out.historicoEstacionamento.SaveHistoricoEstacionamentoPort;
import com.alves.estacionamento.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class FindHistoricoEstabelecimentoPersistenceAdapter implements FindHistoricoEstacionamentoPort {

    private final HistoricoEstacionamentoPersistenceMapper historicoEstacionamentoPersistenceMapper;
    private final VeiculoPersistenceMapper veiculoPersistenceMapper;
    private final EstabelecimentoPersistenceMapper estabelecimentoPersistenceMapper;
    private final HistoricoEstacionamentoRepository historicoEstacionamentoRepository;

    @Override
    public Optional<HistoricoEstacionamento> find(OffsetDateTime dateTime, Veiculo veiculo, Estabelecimento estabelecimento) {
        VeiculoEntity veiculoEntity = veiculoPersistenceMapper.toEntity(veiculo);
        EstabelecimentoEntity estabelecimentoEntity = estabelecimentoPersistenceMapper.toEntity(estabelecimento, new CycleAvoidingMappingContext());

        Optional<HistoricoEstacionamentoEntity> historicoEstacionamentoEntityO = historicoEstacionamentoRepository
                .findByDataEntradaAndAndVeiculoAndEstabelecimento(dateTime, veiculoEntity, estabelecimentoEntity);

        if (historicoEstacionamentoEntityO.isEmpty()) {
            return Optional.empty();
        }

        HistoricoEstacionamento historicoEstacionamento = historicoEstacionamentoPersistenceMapper.toDomain(historicoEstacionamentoEntityO.get(), new CycleAvoidingMappingContext());
        return Optional.of(historicoEstacionamento);
    }
}
