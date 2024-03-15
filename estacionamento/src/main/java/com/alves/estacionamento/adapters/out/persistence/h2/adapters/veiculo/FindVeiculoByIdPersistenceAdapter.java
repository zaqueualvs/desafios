package com.alves.estacionamento.adapters.out.persistence.h2.adapters.veiculo;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.VeiculoEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.mappers.VeiculoPersistenceMapper;
import com.alves.estacionamento.adapters.out.persistence.h2.repositories.VeiculoRepository;
import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.out.veiculo.FindVeiculoByIdPort;
import com.alves.estacionamento.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class FindVeiculoByIdPersistenceAdapter implements FindVeiculoByIdPort {

    private final VeiculoPersistenceMapper veiculoPersistenceMapper;
    private final VeiculoRepository veiculoRepository;

    @Override
    public Optional<Veiculo> find(Long id) {
        Optional<VeiculoEntity> veiculoEntityO = veiculoRepository.findById(id);
        if (veiculoEntityO.isEmpty()) {
            return Optional.empty();
        }
        Veiculo veiculo = veiculoPersistenceMapper.toDomain(veiculoEntityO.get());
        return Optional.of(veiculo);
    }
}