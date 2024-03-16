package com.alves.automovel.adapters.out.persistence.h2.mappers;

import com.alves.automovel.adapters.out.persistence.h2.entities.AutomovelEntity;
import com.alves.automovel.application.domain.models.Automovel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutomovelPersistenceMapper {

    Automovel toDomain(AutomovelEntity automovelEntity);

    AutomovelEntity toEntity(Automovel automovel);
}
