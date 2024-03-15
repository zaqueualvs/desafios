package com.alves.estacionamento.application.domain.services.veiculo;

import com.alves.estacionamento.application.domain.exceptions.VeiculoNaoEncontradoException;
import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.in.veiculo.FindVeiculoByIdUseCase;
import com.alves.estacionamento.application.ports.out.veiculo.FindVeiculoByIdPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindVeiculoByIdService implements FindVeiculoByIdUseCase {

    private final FindVeiculoByIdPort findVeiculoByIdPort;


    @Override
    public Veiculo find(Long id) {
        return findVeiculoByIdPort.find(id).orElseThrow(
                () -> new VeiculoNaoEncontradoException(id)
        );
    }
}
