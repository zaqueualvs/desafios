package com.alves.estacionamento.application.domain.services.veiculo;

import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.in.veiculo.UpdateVeiculoUseCase;
import com.alves.estacionamento.application.ports.out.veiculo.UpdateVeiculoPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateVeiculoService implements UpdateVeiculoUseCase {

    private final UpdateVeiculoPort updateVeiculoPort;

    @Override
    public Veiculo update(Veiculo veiculo) {
        return updateVeiculoPort.update(veiculo);
    }
}
