package com.alves.planetas.core.usecase;

import com.alves.planetas.core.domain.Planeta;

import java.util.List;

public interface FindAllPlanetaUseCase {

    public List<Planeta> findAll();
}
