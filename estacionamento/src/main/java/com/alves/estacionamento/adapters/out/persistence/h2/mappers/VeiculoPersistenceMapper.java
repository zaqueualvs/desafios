package com.alves.estacionamento.adapters.out.persistence.h2.mappers;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.VeiculoEntity;
import org.mapstruct.Mapper;
import com.alves.estacionamento.application.domain.models.Veiculo;

@Mapper(componentModel = "spring")
public interface VeiculoPersistenceMapper {

    VeiculoEntity toEntity(Veiculo veiculo);

    Veiculo toDomain(VeiculoEntity veiculoEntity);
}
