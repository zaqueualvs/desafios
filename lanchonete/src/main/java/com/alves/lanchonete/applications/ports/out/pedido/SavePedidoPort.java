package com.alves.lanchonete.applications.ports.out.pedido;

import com.alves.lanchonete.domain.models.Pedido;

public interface SavePedidoPort {

     Pedido save(Pedido pedido);
}
