package com.alves.lanchonete.adapters.in.rest.mappers;

import com.alves.lanchonete.adapters.in.rest.data.request.ClienteRequest;
import com.alves.lanchonete.adapters.in.rest.data.response.ClienteFullResponse;
import com.alves.lanchonete.adapters.in.rest.data.response.ClienteResponse;
import com.alves.lanchonete.domain.models.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteRestMapper {

    Cliente toDomain(ClienteRequest clienteRequest);

    ClienteResponse toResponse(Cliente cliente);

    ClienteFullResponse toFullResponse(Cliente cliente);
}
