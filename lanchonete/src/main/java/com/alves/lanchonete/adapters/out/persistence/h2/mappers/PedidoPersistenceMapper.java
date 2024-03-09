package com.alves.lanchonete.adapters.out.persistence.h2.mappers;

import com.alves.lanchonete.adapters.out.persistence.h2.entities.ClienteEntity;
import com.alves.lanchonete.adapters.out.persistence.h2.entities.PedidoEntity;
import com.alves.lanchonete.domain.models.Cliente;
import com.alves.lanchonete.domain.models.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoPersistenceMapper {

    Pedido toDomain(PedidoEntity pedidoEntity);

    PedidoEntity toEntity(Pedido pedido);

    @Mapping(target = "pedidos", ignore = true)
    Cliente clienteEntityToCliente(ClienteEntity clienteEntity);

    @Mapping(target = "pedidos", ignore = true)
    ClienteEntity clienteToClienteEntity(Cliente cliente);
}
