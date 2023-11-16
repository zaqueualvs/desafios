package com.alves.planetas.core.ports;

import com.alves.planetas.core.domain.Planeta;

import java.util.List;
import java.util.Optional;

public interface PlanetaRepositoryService {

    public Planeta create(Planeta planeta);
    public List<Planeta> findAll();
    public Optional<Planeta>  findByNome(String nome);
    public Optional<Planeta> findById(Long id);
    public void deleteById(Long id);


}
