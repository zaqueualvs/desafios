package com.alves.estacionamento.application.domain.services.veiculo;

import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.in.veiculo.SaveVeiculoUseCase;
import com.alves.estacionamento.application.ports.out.veiculo.SaveVeiculoPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SaveVeiculoService implements SaveVeiculoUseCase {
    private final SaveVeiculoPort saveVeiculoPort;

    @Override
    public Veiculo save(Veiculo veiculo) {
        return saveVeiculoPort.save(veiculo);
    }
}
