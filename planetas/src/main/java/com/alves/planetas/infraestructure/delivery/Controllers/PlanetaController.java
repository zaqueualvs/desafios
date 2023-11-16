package com.alves.planetas.infraestructure.delivery.Controllers;

import com.alves.planetas.core.domain.Planeta;
import com.alves.planetas.infraestructure.delivery.rest.PlanetaRest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface PlanetaController {

    public ResponseEntity<PlanetaRest> create(PlanetaRest planetaRest);

    public ResponseEntity<List<PlanetaRest>> findAll();

    public ResponseEntity<String> deleteById(Long id);

    public ResponseEntity<Optional<PlanetaRest>> findById(Long id);

    public ResponseEntity<Optional<PlanetaRest>> findByNome(String nome);
}
