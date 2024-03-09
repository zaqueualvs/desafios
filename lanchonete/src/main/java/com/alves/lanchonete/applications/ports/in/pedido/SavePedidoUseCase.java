package com.alves.lanchonete.applications.ports.in.pedido;

import com.alves.lanchonete.domain.models.Pedido;

public interface SavePedidoUseCase {
    Pedido save(Pedido pedido);
}
