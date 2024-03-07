package com.alves.lanchonete.pedido.adapters.in.rest.mappers;

import com.alves.lanchonete.cliente.domain.models.Cliente;
import com.alves.lanchonete.pedido.adapters.in.rest.data.request.PedidoDeleteRequest;
import com.alves.lanchonete.pedido.adapters.in.rest.data.request.PedidoRequest;
import com.alves.lanchonete.pedido.adapters.in.rest.data.response.PedidoResponse;
import com.alves.lanchonete.pedido.domain.models.Pedido;
import com.alves.lanchonete.produto.domain.models.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoRestMapper {

    @Mapping(source = "produtoId", target = "produto")
    @Mapping(source = "clienteId", target = "cliente")
    Pedido toDomain(PedidoRequest pedidoRequest);

    @Mapping(source = "clienteId", target = "cliente")
    @Mapping(target = "status", ignore = true)
    Pedido toDomain(PedidoDeleteRequest pedidoDeleteRequest);

    PedidoResponse toResponse(Pedido pedido);

    default Produto produtoIdToProduto(Long produtoId) {
        if (produtoId == null) {
            return null;
        }

        Produto produto = new Produto();
        produto.setId(produtoId);

        return produto;
    }

    default Cliente clienteIdToCliente(Long clienteId) {
        if (clienteId == null) {
            return null;
        }

        Cliente cliente = new Cliente();
        cliente.setId(clienteId);

        return cliente;
    }
}
