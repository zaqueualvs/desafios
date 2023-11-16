package com.alves.planetas.core.usecase.impl;

import com.alves.planetas.core.domain.Planeta;
import com.alves.planetas.core.ports.PlanetaRepositoryService;
import com.alves.planetas.core.usecase.FindAllPlanetaUseCase;

import java.util.List;

public class FindAllPlanetaUseCaseImpl implements FindAllPlanetaUseCase {
    private final PlanetaRepositoryService planetaRepositoryService;

    public FindAllPlanetaUseCaseImpl(PlanetaRepositoryService planetaRepositoryService) {
        this.planetaRepositoryService = planetaRepositoryService;
    }

    public List<Planeta> findAll(){
        return planetaRepositoryService.findAll();
    }
}
