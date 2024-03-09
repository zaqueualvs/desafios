package com.alves.lanchonete.adapters.out.persistence.h2.mappers;

import com.alves.lanchonete.adapters.out.persistence.h2.entities.ProdutoEntity;
import com.alves.lanchonete.domain.models.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoPersistenceMapper {

    Produto toDomain(ProdutoEntity produtoEntity);

    ProdutoEntity toEntity(Produto produto);
}
