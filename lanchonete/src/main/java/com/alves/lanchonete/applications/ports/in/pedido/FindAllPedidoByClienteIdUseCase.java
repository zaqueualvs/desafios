package com.alves.lanchonete.applications.ports.in.pedido;

import com.alves.lanchonete.domain.models.Pedido;

import java.util.List;

public interface FindAllPedidoByClienteIdUseCase {

    List<Pedido> find(Long id);
}
