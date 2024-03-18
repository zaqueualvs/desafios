package com.alves.automovel.adapters.out.persistence.h2.adapters;

import com.alves.automovel.adapters.out.persistence.h2.entities.AutomovelEntity;
import com.alves.automovel.adapters.out.persistence.h2.mappers.AutomovelPersistenceMapper;
import com.alves.automovel.adapters.out.persistence.h2.repositories.AutomovelRepository;
import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.out.SaveAutomovelPort;
import com.alves.automovel.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class SaveAutomovelPersistenceAdapter implements SaveAutomovelPort {
    private final AutomovelRepository automovelRepository;
    private final AutomovelPersistenceMapper automovelPersistenceMapper;

    @Override
    public Automovel save(Automovel automovel) {
        AutomovelEntity automovelEntity = automovelPersistenceMapper.toEntity(automovel);
        automovelEntity = automovelRepository.save(automovelEntity);
        automovel = automovelPersistenceMapper.toDomain(automovelEntity);
        return automovel;
    }
}
