package com.alves.lanchonete.pedido.application.ports.in;

import com.alves.lanchonete.pedido.domain.models.Pedido;

public interface SavePedidoUseCase {

    Pedido save(Pedido pedido);
}
