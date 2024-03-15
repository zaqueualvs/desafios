package com.alves.estacionamento.application.ports.in.veiculo;

import com.alves.estacionamento.application.domain.models.Veiculo;

public interface SaveVeiculoUseCase {

    Veiculo save(Veiculo veiculo);
}
