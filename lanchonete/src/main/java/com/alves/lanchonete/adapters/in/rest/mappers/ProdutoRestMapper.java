package com.alves.lanchonete.adapters.in.rest.mappers;

import com.alves.lanchonete.adapters.in.rest.data.request.ProdutoRequest;
import com.alves.lanchonete.adapters.in.rest.data.response.ProdutoResponse;
import com.alves.lanchonete.domain.models.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoRestMapper {

    Produto toDomain(ProdutoRequest produtoRequest);

    ProdutoResponse toResponse(Produto produto);
}
