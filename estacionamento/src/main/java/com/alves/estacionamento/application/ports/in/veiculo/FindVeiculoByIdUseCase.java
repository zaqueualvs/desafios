package com.alves.estacionamento.application.ports.in.veiculo;

import com.alves.estacionamento.application.domain.models.Veiculo;

public interface FindVeiculoByIdUseCase {

    Veiculo find(Long id);
}
