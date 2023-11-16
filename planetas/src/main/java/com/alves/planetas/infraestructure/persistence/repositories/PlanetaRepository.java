package com.alves.planetas.infraestructure.persistence.repositories;

import com.alves.planetas.infraestructure.persistence.entities.PlanetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetaRepository extends JpaRepository<PlanetaEntity, Long> {

    public Optional<PlanetaEntity> findByNome(String nome);
}
