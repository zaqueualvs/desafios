package com.alves.planetas.infraestructure.persistence.converters;

import com.alves.planetas.core.domain.Planeta;
import com.alves.planetas.infraestructure.persistence.entities.PlanetaEntity;
import com.alves.planetas.infraestructure.shared.RepositoryConverter;

public class PlanetaRepositoryConverter implements RepositoryConverter<Planeta, PlanetaEntity> {

    @Override
    public Planeta mapToDomain(PlanetaEntity entity) {
        return new Planeta(entity.getId(),
                entity.getNome(),
                entity.getClima(),
                entity.getTerreno());
    }

    @Override
    public PlanetaEntity mapToEntity(Planeta domain) {
        return new PlanetaEntity(domain.getId(),
                domain.getNome(),
                domain.getClima(),
                domain.getTerreno());
    }
}
