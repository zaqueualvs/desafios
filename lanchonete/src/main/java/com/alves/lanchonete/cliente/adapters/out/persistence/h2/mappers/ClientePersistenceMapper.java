package com.alves.lanchonete.cliente.adapters.out.persistence.h2.mappers;

import com.alves.lanchonete.cliente.adapters.out.persistence.h2.entities.ClienteEntity;
import com.alves.lanchonete.cliente.domain.models.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientePersistenceMapper {

    Cliente toDomain(ClienteEntity clienteEntity);

    ClienteEntity toEntity(Cliente cliente);
}
