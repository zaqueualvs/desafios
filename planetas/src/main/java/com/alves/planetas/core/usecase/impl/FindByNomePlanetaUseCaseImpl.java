package com.alves.planetas.core.usecase.impl;

import com.alves.planetas.core.domain.Planeta;
import com.alves.planetas.core.ports.PlanetaRepositoryService;
import com.alves.planetas.core.usecase.FindByNomePlanetaUseCase;

import java.util.Optional;

public class FindByNomePlanetaUseCaseImpl implements FindByNomePlanetaUseCase {
    private final PlanetaRepositoryService planetaRepositoryService;

    public FindByNomePlanetaUseCaseImpl(PlanetaRepositoryService planetaRepositoryService) {
        this.planetaRepositoryService = planetaRepositoryService;
    }


    public Optional<Planeta> findByNome(String nome){
        return planetaRepositoryService.findByNome(nome);
    }
}
