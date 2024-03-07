package com.alves.lanchonete.cliente.adapters.in.rest.mappers;

import com.alves.lanchonete.cliente.adapters.in.rest.data.request.ClienteRequest;
import com.alves.lanchonete.cliente.adapters.in.rest.data.response.ClienteResponse;
import com.alves.lanchonete.cliente.adapters.out.persistence.h2.entities.ClienteEntity;
import com.alves.lanchonete.cliente.domain.models.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteRestMapper {

    Cliente toDomain(ClienteRequest clienteRequest);

    ClienteResponse toResponse(Cliente cliente);
}
