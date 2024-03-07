package com.alves.lanchonete.pedido.application.ports.out;

import com.alves.lanchonete.pedido.domain.models.Pedido;

public interface DeletePedidoByIdPort {

    void delete(Pedido pedido);
}
