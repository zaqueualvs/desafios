package com.alves.lanchonete.adapters.in.rest.mappers;

import com.alves.lanchonete.adapters.in.rest.data.request.ClientePedidoRequest;
import com.alves.lanchonete.adapters.in.rest.data.request.ClienteRequest;
import com.alves.lanchonete.adapters.in.rest.data.response.PedidoFullResponse;
import com.alves.lanchonete.domain.models.Cliente;
import com.alves.lanchonete.adapters.in.rest.data.request.PedidoRequest;
import com.alves.lanchonete.adapters.in.rest.data.response.PedidoResponse;
import com.alves.lanchonete.domain.models.Pedido;
import com.alves.lanchonete.domain.models.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoRestMapper {

    Pedido toDomain(PedidoRequest pedidoRequest);

    PedidoResponse toResponse(Pedido pedido);

    PedidoFullResponse toFullResponse(Pedido pedido);

}
