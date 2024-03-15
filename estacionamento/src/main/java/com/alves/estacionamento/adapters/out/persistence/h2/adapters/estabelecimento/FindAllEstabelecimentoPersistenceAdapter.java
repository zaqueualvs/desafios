package com.alves.estacionamento.adapters.out.persistence.h2.adapters.estabelecimento;

import com.alves.estacionamento.adapters.out.persistence.h2.mappers.CycleAvoidingMappingContext;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.EstabelecimentoPersistenceMapper;
import com.alves.estacionamento.adapters.out.persistence.h2.repositories.EstabelecimentoRepository;
import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.ports.out.estabelecimento.FindAllEstabelecimentoPort;
import com.alves.estacionamento.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class FindAllEstabelecimentoPersistenceAdapter implements FindAllEstabelecimentoPort {
    private final EstabelecimentoPersistenceMapper estabelecimentoPersistenceMapper;
    private final EstabelecimentoRepository estabelecimentoRepository;

    @Override
    public List<Estabelecimento> find() {
        return estabelecimentoRepository.findAll()
                .stream()
                .map(a -> estabelecimentoPersistenceMapper.toDomain(a, new CycleAvoidingMappingContext()))
                .toList();
    }
}
