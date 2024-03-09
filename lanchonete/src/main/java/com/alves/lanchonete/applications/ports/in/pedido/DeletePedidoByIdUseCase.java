package com.alves.lanchonete.applications.ports.in.pedido;

import com.alves.lanchonete.domain.models.Pedido;

public interface DeletePedidoByIdUseCase {

    void delete(Pedido pedido);
}
