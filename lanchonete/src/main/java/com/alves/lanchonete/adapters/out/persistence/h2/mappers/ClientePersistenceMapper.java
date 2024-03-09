package com.alves.lanchonete.adapters.out.persistence.h2.mappers;

import com.alves.lanchonete.adapters.out.persistence.h2.entities.ClienteEntity;
import com.alves.lanchonete.adapters.out.persistence.h2.entities.PedidoEntity;
import com.alves.lanchonete.domain.models.Cliente;
import com.alves.lanchonete.domain.models.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientePersistenceMapper {

    Cliente toDomain(ClienteEntity clienteEntity);

    ClienteEntity toEntity(Cliente cliente);

    @Mapping(target = "cliente", ignore = true)
    Pedido pedidoEntityToPedido(PedidoEntity pedidoEntity);

    @Mapping(target = "cliente", ignore = true)
    PedidoEntity pedidoToPedidoEntity(Pedido pedido);
}
