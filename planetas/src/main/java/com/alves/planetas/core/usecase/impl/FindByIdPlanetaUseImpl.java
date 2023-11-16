package com.alves.planetas.core.usecase.impl;

import com.alves.planetas.core.domain.Planeta;
import com.alves.planetas.core.ports.PlanetaRepositoryService;
import com.alves.planetas.core.usecase.FindByIdPlanetaUseCase;

import java.util.Optional;

public class FindByIdPlanetaUseImpl implements FindByIdPlanetaUseCase {

    private final PlanetaRepositoryService planetaRepositoryService;

    public FindByIdPlanetaUseImpl(PlanetaRepositoryService planetaRepositoryService) {
        this.planetaRepositoryService = planetaRepositoryService;
    }

    public Optional<Planeta> findById(Long id){
        return planetaRepositoryService.findById(id);
    }
}
