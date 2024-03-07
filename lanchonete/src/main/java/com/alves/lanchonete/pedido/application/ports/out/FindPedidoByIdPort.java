package com.alves.lanchonete.pedido.application.ports.out;

import com.alves.lanchonete.pedido.domain.models.Pedido;

import java.util.Optional;

public interface FindPedidoByIdPort {

    Optional<Pedido> findById(Long id);
}
