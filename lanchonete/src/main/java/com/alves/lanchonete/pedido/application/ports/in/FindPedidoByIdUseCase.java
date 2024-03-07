package com.alves.lanchonete.pedido.application.ports.in;

import com.alves.lanchonete.pedido.domain.models.Pedido;

public interface FindPedidoByIdUseCase {

    Pedido findById(Long id);
}
