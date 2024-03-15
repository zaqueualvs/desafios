package com.alves.estacionamento.application.ports.out.veiculo;

import com.alves.estacionamento.application.domain.models.Veiculo;

import java.util.Optional;

public interface FindVeiculoByIdPort {

    Optional<Veiculo> find(Long id);
}
