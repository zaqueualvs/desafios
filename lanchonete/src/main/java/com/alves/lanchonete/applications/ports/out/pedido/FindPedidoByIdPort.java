package com.alves.lanchonete.applications.ports.out.pedido;

import com.alves.lanchonete.domain.models.Pedido;

import java.util.Optional;

public interface FindPedidoByIdPort {

    Optional<Pedido> findById(Long id);
}
