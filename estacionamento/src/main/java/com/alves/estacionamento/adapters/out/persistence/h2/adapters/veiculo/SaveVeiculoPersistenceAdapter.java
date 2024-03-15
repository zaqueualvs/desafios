package com.alves.estacionamento.adapters.out.persistence.h2.adapters.veiculo;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.VeiculoEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.VeiculoPersistenceMapper;
import com.alves.estacionamento.adapters.out.persistence.h2.repositories.VeiculoRepository;
import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.out.veiculo.SaveVeiculoPort;
import com.alves.estacionamento.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class SaveVeiculoPersistenceAdapter implements SaveVeiculoPort {
    private final VeiculoRepository veiculoRepository;
    private final VeiculoPersistenceMapper veiculoPersistenceMapper;

    @Override
    public Veiculo save(Veiculo veiculo) {
        VeiculoEntity veiculoEntity = veiculoPersistenceMapper.toEntity(veiculo);
        veiculoEntity = veiculoRepository.save(veiculoEntity);
        veiculo = veiculoPersistenceMapper.toDomain(veiculoEntity);
        return veiculo;
    }
}
