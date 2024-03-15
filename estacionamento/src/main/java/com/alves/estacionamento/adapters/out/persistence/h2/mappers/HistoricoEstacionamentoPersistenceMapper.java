package com.alves.estacionamento.adapters.out.persistence.h2.mappers;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.HistoricoEstacionamentoEntity;
import com.alves.estacionamento.application.domain.models.HistoricoEstacionamento;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
        uses = {VeiculoPersistenceMapper.class,
                EstabelecimentoPersistenceMapper.class})
public interface HistoricoEstacionamentoPersistenceMapper {

    HistoricoEstacionamentoEntity toEntity(HistoricoEstacionamento historicoEstacionamento, @Context CycleAvoidingMappingContext context);

    HistoricoEstacionamento toDomain(HistoricoEstacionamentoEntity historicoEstacionamentoEntity, @Context CycleAvoidingMappingContext context);
}
