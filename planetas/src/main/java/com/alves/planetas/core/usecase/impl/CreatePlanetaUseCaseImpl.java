package com.alves.planetas.core.usecase.impl;

import com.alves.planetas.core.domain.Planeta;
import com.alves.planetas.core.ports.PlanetaRepositoryService;
import com.alves.planetas.core.usecase.CreatePlanetaUseCase;

public class CreatePlanetaUseCaseImpl implements CreatePlanetaUseCase {

    private final PlanetaRepositoryService planetaRepositoryService;

    public CreatePlanetaUseCaseImpl(PlanetaRepositoryService planetaRepositoryService) {
        this.planetaRepositoryService = planetaRepositoryService;
    }

    @Override
    public Planeta create(Planeta planeta){
        return planetaRepositoryService.create(planeta);
    }
}
