package com.alves.estacionamento.application.ports.out.veiculo;

import com.alves.estacionamento.application.domain.models.Veiculo;

public interface UpdateVeiculoPort {

    Veiculo update(Veiculo veiculo);
}
