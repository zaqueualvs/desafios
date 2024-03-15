package com.alves.estacionamento.adapters.in.rest.mappers;

import com.alves.estacionamento.adapters.in.rest.data.request.VeiculoRequest;
import com.alves.estacionamento.adapters.in.rest.data.response.VeiculoResponse;
import com.alves.estacionamento.application.domain.models.Veiculo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VeiculoRestMapper {

    Veiculo toDomain(VeiculoRequest veiculoRequest);

    VeiculoResponse toResponse(Veiculo veiculo);
}
