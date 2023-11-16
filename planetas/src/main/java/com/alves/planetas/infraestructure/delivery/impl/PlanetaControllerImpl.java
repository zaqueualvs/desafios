package com.alves.planetas.infraestructure.delivery.impl;

import com.alves.planetas.core.usecase.*;
import com.alves.planetas.infraestructure.delivery.Controllers.PlanetaController;
import com.alves.planetas.infraestructure.delivery.Converters.PlanetaRestConverter;
import com.alves.planetas.infraestructure.delivery.rest.PlanetaRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/planeta")
public class PlanetaControllerImpl implements PlanetaController {

    @Autowired
    private PlanetaRestConverter planetaRestConverter;
    @Autowired
    private CreatePlanetaUseCase createPlanetaUseCase;
    @Autowired
    private FindAllPlanetaUseCase findAllPlanetaUseCase;
    @Autowired
    private DeleteByIdPlanetaUseCase deleteByIdPlanetaUseCase;
    @Autowired
    private FindByIdPlanetaUseCase findByIdPlanetaUseCase;
    @Autowired
    private FindByNomePlanetaUseCase findByNomePlanetaUseCase;


    @PostMapping
    @Override
    public ResponseEntity<PlanetaRest> create(@RequestBody PlanetaRest planetaRest) {
        var planeta = createPlanetaUseCase.create(planetaRestConverter.mapToDomain(planetaRest));
        return ResponseEntity.status(HttpStatus.CREATED).body(planetaRestConverter.mapToRest(planeta));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<PlanetaRest>> findAll() {
        List<PlanetaRest> planetaRests = findAllPlanetaUseCase.findAll()
                .stream()
                .map(planeta -> planetaRestConverter.mapToRest(planeta))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(planetaRests);
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id) {
        deleteByIdPlanetaUseCase.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Planeta deletado");
    }

    @GetMapping(value = "/id/{id}")
    @Override
    public ResponseEntity<Optional<PlanetaRest>> findById(@PathVariable(name = "id")Long id) {
        var planetaRest = planetaRestConverter.mapToRest(findByIdPlanetaUseCase.findById(id).get());
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(planetaRest));
    }

    @GetMapping(value = {"/nome/{nome}"})
    @Override
    public ResponseEntity<Optional<PlanetaRest>> findByNome(@PathVariable(name = "nome")String nome) {
        var planetaRest = planetaRestConverter.mapToRest(findByNomePlanetaUseCase.findByNome(nome).get());
        return ResponseEntity.status(HttpStatus.OK).body(Optional.ofNullable(planetaRest));
    }
}
