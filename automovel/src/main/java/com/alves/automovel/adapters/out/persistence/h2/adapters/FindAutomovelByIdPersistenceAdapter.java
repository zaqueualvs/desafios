package com.alves.automovel.adapters.out.persistence.h2.adapters;

import com.alves.automovel.adapters.out.persistence.h2.entities.AutomovelEntity;
import com.alves.automovel.adapters.out.persistence.h2.mappers.AutomovelPersistenceMapper;
import com.alves.automovel.adapters.out.persistence.h2.repositories.AutomovelRepository;
import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.out.FindAutomovelByIdPort;
import com.alves.automovel.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindAutomovelByIdPersistenceAdapter implements FindAutomovelByIdPort {

    private final AutomovelRepository automovelRepository;
    private final AutomovelPersistenceMapper automovelPersistenceMapper;

    @Override
    public Optional<Automovel> find(Long id) {
        Optional<AutomovelEntity> automovelEntityO = automovelRepository.findById(id);
        if (automovelEntityO.isEmpty()) {
            return Optional.empty();
        }
        Automovel automovel = automovelPersistenceMapper.toDomain(automovelEntityO.get());
        return Optional.of(automovel);
    }
}
