package com.alves.planetas.infraestructure.Configuration;

import com.alves.planetas.core.usecase.FindAllPlanetaUseCase;
import com.alves.planetas.core.usecase.FindByIdPlanetaUseCase;
import com.alves.planetas.core.usecase.FindByNomePlanetaUseCase;
import com.alves.planetas.core.usecase.impl.*;
import com.alves.planetas.infraestructure.delivery.Converters.PlanetaRestConverter;
import com.alves.planetas.infraestructure.delivery.rest.PlanetaRest;
import com.alves.planetas.infraestructure.persistence.converters.PlanetaRepositoryConverter;
import com.alves.planetas.infraestructure.persistence.impl.PlanetaServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlanetaConfig {


    @Bean
    public PlanetaRepositoryConverter createPlanetaRepositoryConverter() {
        return new PlanetaRepositoryConverter();
    }
    @Bean
    public PlanetaRestConverter createPlanetaRestConverter() {
        return new PlanetaRestConverter();
    }

    @Bean
    public PlanetaServiceImpl createPlanetaServiceImpl(){
        return new PlanetaServiceImpl();
    }

    @Bean
    public CreatePlanetaUseCaseImpl createCreatePlanetaUseCaseImpl(){
        return new CreatePlanetaUseCaseImpl(createPlanetaServiceImpl());
    }

    @Bean
    public DeleteByIdPlanetaUseCaseImpl createDeleteByIdPlanetaUseCaseImpl(){
        return new DeleteByIdPlanetaUseCaseImpl(createPlanetaServiceImpl());
    }

    @Bean
    public FindAllPlanetaUseCase createFindAllPlanetaUseCase(){
        return new FindAllPlanetaUseCaseImpl(createPlanetaServiceImpl());
    }

    @Bean
    public FindByIdPlanetaUseCase createFindByIdPlanetaUseCase(){
        return new FindByIdPlanetaUseImpl(createPlanetaServiceImpl());
    }

    @Bean
    public FindByNomePlanetaUseCaseImpl createFindByNomePlanetaUseCase(){
        return new FindByNomePlanetaUseCaseImpl(createPlanetaServiceImpl());
    }
}
