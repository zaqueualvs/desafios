package com.alves.estacionamento.adapters.out.persistence.h2.adapters.veiculo;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.VeiculoEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.VeiculoPersistenceMapper;
import com.alves.estacionamento.adapters.out.persistence.h2.repositories.VeiculoRepository;
import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.out.veiculo.DeleteVeiculoPort;
import com.alves.estacionamento.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class DeleteVeiculoByIdPersistenceAdapter implements DeleteVeiculoPort {

    private final VeiculoPersistenceMapper veiculoPersistenceMapper;
    private final VeiculoRepository veiculoRepository;

    @Override
    public void delete(Veiculo veiculo) {
        VeiculoEntity veiculoEntity = veiculoPersistenceMapper.toEntity(veiculo);
        veiculoRepository.delete(veiculoEntity);
    }
}