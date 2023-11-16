package com.alves.planetas.infraestructure.persistence.impl;

import com.alves.planetas.core.domain.Planeta;
import com.alves.planetas.core.ports.PlanetaRepositoryService;
import com.alves.planetas.infraestructure.persistence.converters.PlanetaRepositoryConverter;
import com.alves.planetas.infraestructure.persistence.repositories.PlanetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanetaServiceImpl implements PlanetaRepositoryService {

    @Autowired
    private PlanetaRepositoryConverter planetaRepositoryConverter;
    @Autowired
    private PlanetaRepository planetaRepository;

    @Override
    public Planeta create(Planeta planeta) {
        var planetaEntity = planetaRepository.save(planetaRepositoryConverter.mapToEntity(planeta));
        return planetaRepositoryConverter.mapToDomain(planetaEntity);
    }

    @Override
    public List<Planeta> findAll() {
        return planetaRepository.findAll().stream()
                .map(entity -> planetaRepositoryConverter.mapToDomain(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Planeta> findByNome(String nome) {
        var planetaEntity = planetaRepository.findByNome(nome);
        return Optional.ofNullable(planetaRepositoryConverter.mapToDomain(planetaEntity.get()));
    }

    @Override
    public Optional<Planeta> findById(Long id) {
        var planetaEntity = planetaRepository.findById(id);
        return Optional.ofNullable(planetaRepositoryConverter.mapToDomain(planetaEntity.get()));
    }

    @Override
    public void deleteById(Long id) {
        planetaRepository.deleteById(id);
    }
}
