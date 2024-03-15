package com.alves.estacionamento.adapters.in.rest.controllers;

import com.alves.estacionamento.adapters.in.rest.data.request.VagaEstacionamentoResquest;
import com.alves.estacionamento.adapters.in.rest.mappers.VagaEstacionamentoRestMapper;
import com.alves.estacionamento.application.domain.models.VagaEstacionamento;
import com.alves.estacionamento.application.ports.in.vagaestacionamento.DeleteVagaEstacionamentoUseCase;
import com.alves.estacionamento.application.ports.in.vagaestacionamento.SaveVagaEstacionamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "estabelecimentos/{estabelecimentoId}/veiculos")
@RequiredArgsConstructor
public class EstabelecimentoVeiculoController {

    private final VagaEstacionamentoRestMapper vagaEstacionamentoRestMapper;
    private final SaveVagaEstacionamentoUseCase saveVagaEstacionamentoUseCase;
    private final DeleteVagaEstacionamentoUseCase deleteVagaEstacionamentoUseCase;

    @PostMapping("/{veiculoId}/entrada")
    public ResponseEntity<Object> entrada(@PathVariable Long estabelecimentoId,
                                          @PathVariable Long veiculoId) {
        VagaEstacionamentoResquest vagaEstacionamentoResquest = new VagaEstacionamentoResquest(veiculoId, estabelecimentoId);
        VagaEstacionamento vagaEstacionamento = vagaEstacionamentoRestMapper.toDomain(vagaEstacionamentoResquest);
        saveVagaEstacionamentoUseCase.save(vagaEstacionamento);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{veiculoId}/saida")
    public ResponseEntity<Object> saida(@PathVariable Long estabelecimentoId,
                                        @PathVariable Long veiculoId) {
        VagaEstacionamentoResquest vagaEstacionamentoResquest = new VagaEstacionamentoResquest(veiculoId, estabelecimentoId);
        VagaEstacionamento vagaEstacionamento = vagaEstacionamentoRestMapper.toDomain(vagaEstacionamentoResquest);
        deleteVagaEstacionamentoUseCase.delete(vagaEstacionamento);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
