package com.alves.lanchonete.applications.ports.out.pedido;

import com.alves.lanchonete.domain.models.Pedido;

public interface DeletePedidoByIdPort {

    void delete(Pedido pedido);
}
