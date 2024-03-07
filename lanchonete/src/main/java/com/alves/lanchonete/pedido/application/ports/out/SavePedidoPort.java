package com.alves.lanchonete.pedido.application.ports.out;

import com.alves.lanchonete.pedido.domain.models.Pedido;

public interface SavePedidoPort {

     Pedido save(Pedido pedido);
}
