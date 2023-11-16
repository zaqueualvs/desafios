package com.alves.planetas.core.usecase;

import com.alves.planetas.core.domain.Planeta;

import java.util.Optional;

public interface FindByNomePlanetaUseCase {
    public Optional<Planeta> findByNome(String nome);
}
