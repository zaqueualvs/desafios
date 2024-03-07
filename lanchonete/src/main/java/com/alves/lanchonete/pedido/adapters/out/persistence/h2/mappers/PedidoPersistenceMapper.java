package com.alves.lanchonete.pedido.adapters.out.persistence.h2.mappers;

import com.alves.lanchonete.pedido.adapters.out.persistence.h2.entities.PedidoEntity;
import com.alves.lanchonete.pedido.domain.models.Pedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoPersistenceMapper {

    Pedido toDomain(PedidoEntity pedidoEntity);

    PedidoEntity toEntity(Pedido pedido);
}
