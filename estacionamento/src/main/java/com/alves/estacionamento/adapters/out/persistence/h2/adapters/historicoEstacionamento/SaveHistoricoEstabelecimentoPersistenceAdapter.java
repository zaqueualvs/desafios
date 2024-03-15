package com.alves.estacionamento.adapters.out.persistence.h2.adapters.historicoEstacionamento;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.HistoricoEstacionamentoEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.CycleAvoidingMappingContext;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.HistoricoEstacionamentoPersistenceMapper;
import com.alves.estacionamento.adapters.out.persistence.h2.repositories.HistoricoEstacionamentoRepository;
import com.alves.estacionamento.application.domain.models.HistoricoEstacionamento;
import com.alves.estacionamento.application.ports.out.historicoEstacionamento.SaveHistoricoEstacionamentoPort;
import com.alves.estacionamento.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class SaveHistoricoEstabelecimentoPersistenceAdapter implements SaveHistoricoEstacionamentoPort {

    private final HistoricoEstacionamentoPersistenceMapper historicoEstacionamentoPersistenceMapper;
    private final HistoricoEstacionamentoRepository historicoEstacionamentoRepository;

    @Override
    public HistoricoEstacionamento save(HistoricoEstacionamento historicoEstacionamento) {

        HistoricoEstacionamentoEntity historicoEstacionamentoEntity = historicoEstacionamentoPersistenceMapper.toEntity(historicoEstacionamento, new CycleAvoidingMappingContext());
        historicoEstacionamentoEntity = historicoEstacionamentoRepository.save(historicoEstacionamentoEntity);
        historicoEstacionamento = historicoEstacionamentoPersistenceMapper.toDomain(historicoEstacionamentoEntity, new CycleAvoidingMappingContext());
        return historicoEstacionamento;
    }
}
