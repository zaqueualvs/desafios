package com.alves.automovel.adapters.out.persistence.h2.adapters;

import com.alves.automovel.adapters.out.persistence.h2.entities.AutomovelEntity;
import com.alves.automovel.adapters.out.persistence.h2.mappers.AutomovelPersistenceMapper;
import com.alves.automovel.adapters.out.persistence.h2.repositories.AutomovelRepository;
import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.out.DeleteAutomovelPort;
import com.alves.automovel.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class DeleteAutomovelPersistenceAdapter implements DeleteAutomovelPort {

    private final AutomovelRepository automovelRepository;
    private final AutomovelPersistenceMapper automovelPersistenceMapper;

    public void delete(Automovel automovel) {
        AutomovelEntity automovelEntity = automovelPersistenceMapper.toEntity(automovel);
        automovelRepository.delete(automovelEntity);
    }
}
