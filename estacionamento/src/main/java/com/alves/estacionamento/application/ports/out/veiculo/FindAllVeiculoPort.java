package com.alves.estacionamento.application.ports.out.veiculo;

import com.alves.estacionamento.application.domain.models.Veiculo;

import java.util.List;

public interface FindAllVeiculoPort {

    List<Veiculo> find();
}
