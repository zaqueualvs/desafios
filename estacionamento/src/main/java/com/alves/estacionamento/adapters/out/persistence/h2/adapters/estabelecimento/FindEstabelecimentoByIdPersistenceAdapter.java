package com.alves.estacionamento.adapters.out.persistence.h2.adapters.estabelecimento;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.EstabelecimentoEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.CycleAvoidingMappingContext;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.EstabelecimentoPersistenceMapper;
import com.alves.estacionamento.adapters.out.persistence.h2.repositories.EstabelecimentoRepository;
import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.ports.out.estabelecimento.FindEstabelecimentoByIdPort;
import com.alves.estacionamento.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class FindEstabelecimentoByIdPersistenceAdapter implements FindEstabelecimentoByIdPort {

    private final EstabelecimentoPersistenceMapper estabelecimentoPersistenceMapper;
    private final EstabelecimentoRepository estabelecimentoRepository;

    @Override
    public Optional<Estabelecimento> find(Long id) {
        Optional<EstabelecimentoEntity> estabelecimentoEntityO = estabelecimentoRepository.findById(id);
        if (estabelecimentoEntityO.isEmpty()) {
            return Optional.empty();
        }
        Estabelecimento estabelecimento = estabelecimentoPersistenceMapper.toDomain(estabelecimentoEntityO.get(), new CycleAvoidingMappingContext());
        return Optional.of(estabelecimento);
    }
}
