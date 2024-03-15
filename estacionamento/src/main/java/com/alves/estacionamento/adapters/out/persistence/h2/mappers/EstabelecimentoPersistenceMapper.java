package com.alves.estacionamento.adapters.out.persistence.h2.mappers;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.EstabelecimentoEntity;
import com.alves.estacionamento.application.domain.models.Estabelecimento;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = VeiculoPersistenceMapper.class)
public interface EstabelecimentoPersistenceMapper {

    EstabelecimentoEntity toEntity(Estabelecimento estabelecimento, @Context CycleAvoidingMappingContext context);

    Estabelecimento toDomain(EstabelecimentoEntity estabelecimentoEntity, @Context CycleAvoidingMappingContext context);
}
