package com.alves.planetas.infraestructure.delivery.Converters;

import com.alves.planetas.core.domain.Planeta;
import com.alves.planetas.infraestructure.delivery.rest.PlanetaRest;
import com.alves.planetas.infraestructure.shared.RestConverter;

public class PlanetaRestConverter implements RestConverter<Planeta, PlanetaRest> {

    @Override
    public Planeta mapToDomain(PlanetaRest rest) {
        return new Planeta(rest.getId(),
                rest.getNome(),
                rest.getClima(),
                rest.getTerreno());
    }

    @Override
    public PlanetaRest mapToRest(Planeta domain) {
        return new PlanetaRest(domain.getId(),
                domain.getNome(),
                domain.getClima(),
                domain.getTerreno());
    }
}
