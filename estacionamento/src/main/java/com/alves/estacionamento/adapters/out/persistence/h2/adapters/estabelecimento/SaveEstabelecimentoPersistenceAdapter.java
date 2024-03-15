package com.alves.estacionamento.adapters.out.persistence.h2.adapters.estabelecimento;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.EstabelecimentoEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.CycleAvoidingMappingContext;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.EstabelecimentoPersistenceMapper;
import com.alves.estacionamento.adapters.out.persistence.h2.repositories.EstabelecimentoRepository;
import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.ports.out.estabelecimento.SaveEstabelecimentoPort;
import com.alves.estacionamento.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class SaveEstabelecimentoPersistenceAdapter implements SaveEstabelecimentoPort {

    private final EstabelecimentoPersistenceMapper estabelecimentoPersistenceMapper;
    private final EstabelecimentoRepository estabelecimentoRepository;

    @Override
    public Estabelecimento save(Estabelecimento estabelecimento) {
        EstabelecimentoEntity estabelecimentoEntity = estabelecimentoPersistenceMapper.toEntity(estabelecimento, new CycleAvoidingMappingContext());
        estabelecimentoEntity = estabelecimentoRepository.save(estabelecimentoEntity);
        estabelecimento = estabelecimentoPersistenceMapper.toDomain(estabelecimentoEntity, new CycleAvoidingMappingContext());
        return estabelecimento;
    }
}
