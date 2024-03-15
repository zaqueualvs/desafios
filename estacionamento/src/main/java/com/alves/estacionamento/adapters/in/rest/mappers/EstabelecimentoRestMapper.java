package com.alves.estacionamento.adapters.in.rest.mappers;

import com.alves.estacionamento.adapters.in.rest.data.request.EstabelecimentoRequest;
import com.alves.estacionamento.adapters.in.rest.data.response.EstabelecimentoFullReponse;
import com.alves.estacionamento.adapters.in.rest.data.response.EstabelecimentoReponse;
import com.alves.estacionamento.application.domain.models.Estabelecimento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = VeiculoRestMapper.class)
public interface EstabelecimentoRestMapper {


    Estabelecimento toDomain(EstabelecimentoRequest estabelecimentoRequest);

    EstabelecimentoReponse toResponse(Estabelecimento estabelecimento);

    EstabelecimentoFullReponse toFullResponse(Estabelecimento estabelecimento);
}
