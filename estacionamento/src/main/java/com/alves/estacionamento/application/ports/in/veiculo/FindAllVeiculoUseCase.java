package com.alves.estacionamento.application.ports.in.veiculo;

import com.alves.estacionamento.application.domain.models.Veiculo;

import java.util.List;

public interface FindAllVeiculoUseCase {

    List<Veiculo> find();
}
