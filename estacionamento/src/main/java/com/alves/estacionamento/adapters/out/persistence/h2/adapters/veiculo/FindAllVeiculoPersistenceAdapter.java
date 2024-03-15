package com.alves.estacionamento.adapters.out.persistence.h2.adapters.veiculo;

import com.alves.estacionamento.adapters.out.persistence.h2.mappers.VeiculoPersistenceMapper;
import com.alves.estacionamento.adapters.out.persistence.h2.repositories.VeiculoRepository;
import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.out.veiculo.FindAllVeiculoPort;
import com.alves.estacionamento.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class FindAllVeiculoPersistenceAdapter implements FindAllVeiculoPort {

    private final VeiculoPersistenceMapper veiculoPersistenceMapper;
    private final VeiculoRepository veiculoRepository;

    @Override
    public List<Veiculo> find() {
        return veiculoRepository.findAll()
                .stream()
                .map(veiculoPersistenceMapper::toDomain)
                .toList();
    }
}
