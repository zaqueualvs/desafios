package com.alves.estacionamento.adapters.out.persistence.h2.adapters.veiculo;

import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.out.veiculo.SaveVeiculoPort;
import com.alves.estacionamento.application.ports.out.veiculo.UpdateVeiculoPort;
import com.alves.estacionamento.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class UpdateVeiculoPersistenceAdapter implements UpdateVeiculoPort {
    private final SaveVeiculoPort saveVeiculoPort;

    @Override
    public Veiculo update(Veiculo veiculo) {
        return saveVeiculoPort.save(veiculo);
    }
}
