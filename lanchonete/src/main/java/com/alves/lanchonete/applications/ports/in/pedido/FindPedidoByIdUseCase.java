package com.alves.lanchonete.applications.ports.in.pedido;

import com.alves.lanchonete.domain.models.Pedido;

public interface FindPedidoByIdUseCase {

    Pedido findById(Long id);
}
