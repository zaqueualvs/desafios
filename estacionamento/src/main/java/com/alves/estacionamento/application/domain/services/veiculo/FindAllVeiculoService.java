package com.alves.estacionamento.application.domain.services.veiculo;

import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.in.veiculo.FindAllVeiculoUseCase;
import com.alves.estacionamento.application.ports.out.veiculo.FindAllVeiculoPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllVeiculoService implements FindAllVeiculoUseCase {

    private final FindAllVeiculoPort findAllVeiculoPort;


    @Override
    public List<Veiculo> find() {
        return findAllVeiculoPort.find();
    }
}
