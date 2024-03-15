package com.alves.estacionamento.application.ports.out.veiculo;
import com.alves.estacionamento.application.domain.models.Veiculo;
public interface DeleteVeiculoPort {

    void delete(Veiculo veiculo);
}