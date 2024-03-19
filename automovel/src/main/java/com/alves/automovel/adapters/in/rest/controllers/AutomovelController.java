package com.alves.automovel.adapters.in.rest.controllers;

import com.alves.automovel.adapters.in.rest.data.request.AutomovelRequest;
import com.alves.automovel.adapters.in.rest.data.response.AutomovelResponse;
import com.alves.automovel.adapters.in.rest.mappers.AutomovelRestMapper;
import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.in.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "automoveis")
@RequiredArgsConstructor
public class AutomovelController {

    private final FindAllAutomovelUseCase findAllAutomovelUseCase;
    private final FindAutomovelByIdUseCase findAutomovelByIdUseCase;
    private final DeleteAutomovelByIdUseCase deleteAutomovelByIdUseCase;
    private final SaveAutomovelUseCase saveAutomovelUseCase;
    private final UpdateAutomovelUseCase updateAutomovelUseCase;
    private final AutomovelRestMapper automovelRestMapper;

    @GetMapping
    public ResponseEntity<List<AutomovelResponse>> findAll() {
        List<AutomovelResponse> automovelResponsesList = findAllAutomovelUseCase.find()
                .stream()
                .map(automovelRestMapper::toResponse)
                .map(automovelResponse -> automovelResponse
                        .add(linkTo(methodOn(AutomovelController.class)
                                .findById(automovelResponse.getId()))
                                .withSelfRel()
                        )
                )
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(automovelResponsesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutomovelResponse> findById(@PathVariable Long id) {
        Automovel automovel = findAutomovelByIdUseCase.find(id);
        AutomovelResponse automovelResponse = automovelRestMapper.toResponse(automovel);
        automovelResponse.add(linkTo(methodOn(AutomovelController.class).findAll()).withRel("Todos automoveis"));
        return ResponseEntity.status(HttpStatus.OK).body(automovelResponse);

    }

    @PostMapping
    public ResponseEntity<AutomovelResponse> save(@RequestBody @Valid AutomovelRequest automovelRequest) {
        Automovel automovel = automovelRestMapper.toDomain(automovelRequest);
        automovel = saveAutomovelUseCase.save(automovel);
        AutomovelResponse automovelResponse = automovelRestMapper.toResponse(automovel);
        automovelResponse.add(linkTo(methodOn(AutomovelController.class).findAll()).withRel("Todos automoveis"));
        return ResponseEntity.status(HttpStatus.CREATED).body(automovelResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutomovelResponse> update(@PathVariable Long id,
                                                    @RequestBody @Valid AutomovelRequest automovelRequest) {
        Automovel automovel = findAutomovelByIdUseCase.find(id);
        BeanUtils.copyProperties(automovelRequest, automovel);
        automovel = updateAutomovelUseCase.update(automovel);
        AutomovelResponse automovelResponse = automovelRestMapper.toResponse(automovel);
        automovelResponse.add(linkTo(methodOn(AutomovelController.class).findAll()).withRel("Todos automoveis"));
        return ResponseEntity.status(HttpStatus.OK).body(automovelResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        deleteAutomovelByIdUseCase.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
