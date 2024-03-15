package com.alves.estacionamento.adapters.in.rest.controllers;

import com.alves.estacionamento.adapters.in.rest.data.request.EstabelecimentoRequest;
import com.alves.estacionamento.adapters.in.rest.data.response.EstabelecimentoFullReponse;
import com.alves.estacionamento.adapters.in.rest.data.response.EstabelecimentoReponse;
import com.alves.estacionamento.adapters.in.rest.mappers.EstabelecimentoRestMapper;
import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.ports.in.estabelecimento.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "estabelecimentos")
@RequiredArgsConstructor
public class EstabelecimentoController {

    private final FindEstabelecimentoByIdUseCase findEstabelecimentoByIdUseCase;
    private final SaveEstabelecimentoUseCase saveEstabelecimentoUseCase;
    private final FindAllEstabelecimentoUseCase findAllEstabelecimentoUseCase;
    private final DeleteEstabelecimentoByIdUseCase deleteEstabelecimentoByIdUseCase;
    private final UpdateEstabelecimentoUseCase updateEstabelecimentoUseCase;
    private final EstabelecimentoRestMapper estabelecimentoRestMapper;

    @GetMapping
    public ResponseEntity<List<EstabelecimentoReponse>> findAll() {
        List<EstabelecimentoReponse> estabelecimentoReponses = findAllEstabelecimentoUseCase.find()
                .stream()
                .map(estabelecimentoRestMapper::toResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoReponses);
    }

    @PostMapping
    public ResponseEntity<EstabelecimentoReponse> save(@RequestBody @Valid EstabelecimentoRequest estabelecimentoRequest) {
        Estabelecimento estabelecimento = estabelecimentoRestMapper.toDomain(estabelecimentoRequest);
        estabelecimento = saveEstabelecimentoUseCase.save(estabelecimento);
        EstabelecimentoReponse estabelecimentoReponse = estabelecimentoRestMapper.toResponse(estabelecimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(estabelecimentoReponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstabelecimentoReponse> updateById(@PathVariable Long id,
                                                             @RequestBody @Valid EstabelecimentoRequest estabelecimentoRequest) {
        Estabelecimento estabelecimento = findEstabelecimentoByIdUseCase.find(id);
        BeanUtils.copyProperties(estabelecimentoRequest, estabelecimento, "id", "vagasUsada");
        estabelecimento = updateEstabelecimentoUseCase.update(estabelecimento);
        EstabelecimentoReponse estabelecimentoReponse = estabelecimentoRestMapper.toResponse(estabelecimento);
        return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoReponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstabelecimentoFullReponse> findById(@PathVariable Long id) {
        Estabelecimento estabelecimento = findEstabelecimentoByIdUseCase.find(id);
        EstabelecimentoFullReponse estabelecimentoFullReponse = estabelecimentoRestMapper.toFullResponse(estabelecimento);
        return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoFullReponse);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        deleteEstabelecimentoByIdUseCase.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
