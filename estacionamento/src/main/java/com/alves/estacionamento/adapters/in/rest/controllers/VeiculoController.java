package com.alves.estacionamento.adapters.in.rest.controllers;

import com.alves.estacionamento.adapters.in.rest.data.request.VeiculoRequest;
import com.alves.estacionamento.adapters.in.rest.data.response.VeiculoResponse;
import com.alves.estacionamento.adapters.in.rest.mappers.VeiculoRestMapper;
import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.in.veiculo.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final FindAllVeiculoUseCase findAllVeiculoUseCase;
    private final DeleteVeiculoByIdUseCase deleteVeiculoByIdUseCase;
    private final SaveVeiculoUseCase saveVeiculoUseCase;
    private final FindVeiculoByIdUseCase findVeiculoByIdUseCase;
    private final UpdateVeiculoUseCase updateVeiculoUseCase;
    private final VeiculoRestMapper veiculoRestMapper;

    @GetMapping
    public ResponseEntity<List<VeiculoResponse>> findAll() {
        List<VeiculoResponse> veiculoResponses = findAllVeiculoUseCase.find()
                .stream()
                .map(veiculoRestMapper::toResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(veiculoResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponse> findById(@PathVariable Long id) {
        Veiculo veiculo = findVeiculoByIdUseCase.find(id);
        VeiculoResponse veiculoResponse = veiculoRestMapper.toResponse(veiculo);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoResponse);
    }

    @PostMapping
    public ResponseEntity<VeiculoResponse> saveVeiculo(@RequestBody @Valid VeiculoRequest veiculoRequest) {
        Veiculo veiculo = veiculoRestMapper.toDomain(veiculoRequest);
        veiculo = saveVeiculoUseCase.save(veiculo);
        VeiculoResponse veiculoResponse = veiculoRestMapper.toResponse(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponse> updateVeiculo(@PathVariable Long id,
                                                         @RequestBody @Valid VeiculoRequest veiculoRequest) {
        Veiculo veiculo = findVeiculoByIdUseCase.find(id);
        BeanUtils.copyProperties(veiculoRequest, veiculo, "id");
        veiculo = updateVeiculoUseCase.update(veiculo);
        VeiculoResponse veiculoResponse = veiculoRestMapper.toResponse(veiculo);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) {
        deleteVeiculoByIdUseCase.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
