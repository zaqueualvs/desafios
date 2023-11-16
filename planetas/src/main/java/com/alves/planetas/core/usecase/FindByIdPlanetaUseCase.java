package com.alves.planetas.core.usecase;

import com.alves.planetas.core.domain.Planeta;

import java.util.Optional;

public interface FindByIdPlanetaUseCase {
    public Optional<Planeta> findById(Long id);
}
