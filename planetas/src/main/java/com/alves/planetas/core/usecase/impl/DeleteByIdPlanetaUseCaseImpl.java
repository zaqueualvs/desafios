package com.alves.planetas.core.usecase.impl;

import com.alves.planetas.core.ports.PlanetaRepositoryService;
import com.alves.planetas.core.usecase.DeleteByIdPlanetaUseCase;

public class DeleteByIdPlanetaUseCaseImpl implements DeleteByIdPlanetaUseCase {

    private final PlanetaRepositoryService planetaRepositoryService;

    public DeleteByIdPlanetaUseCaseImpl(PlanetaRepositoryService planetaRepositoryService) {
        this.planetaRepositoryService = planetaRepositoryService;
    }

    @Override
    public void deleteById(Long id){
        planetaRepositoryService.deleteById(id);
    }
}
