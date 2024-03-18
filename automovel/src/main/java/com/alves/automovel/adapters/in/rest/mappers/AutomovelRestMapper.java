package com.alves.automovel.adapters.in.rest.mappers;

import com.alves.automovel.adapters.in.rest.data.request.AutomovelRequest;
import com.alves.automovel.adapters.in.rest.data.response.AutomovelResponse;
import com.alves.automovel.application.domain.models.Automovel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutomovelRestMapper {

    Automovel toDomain(AutomovelRequest automovelRequest);

    AutomovelResponse toResponse(Automovel automovel);
}
