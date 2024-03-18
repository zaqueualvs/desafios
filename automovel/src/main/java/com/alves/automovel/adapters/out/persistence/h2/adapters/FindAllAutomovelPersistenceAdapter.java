package com.alves.automovel.adapters.out.persistence.h2.adapters;

import com.alves.automovel.adapters.out.persistence.h2.mappers.AutomovelPersistenceMapper;
import com.alves.automovel.adapters.out.persistence.h2.repositories.AutomovelRepository;
import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.out.FindAllAutomovelPort;
import com.alves.automovel.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindAllAutomovelPersistenceAdapter implements FindAllAutomovelPort {

    private final AutomovelRepository automovelRepository;
    private final AutomovelPersistenceMapper automovelPersistenceMapper;

    @Override
    public List<Automovel> find() {
        return automovelRepository.findAll()
                .stream()
                .map(automovelPersistenceMapper::toDomain)
                .toList();
    }
}
