package com.alves.lanchonete.pedido.domain.services;

import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.pedido.application.ports.in.FindPedidoByIdUseCase;
import com.alves.lanchonete.pedido.application.ports.out.FindPedidoByIdPort;
import com.alves.lanchonete.pedido.domain.models.Pedido;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class FindPedidoByIdService implements FindPedidoByIdUseCase {

    private final FindPedidoByIdPort findPedidoByIdPort;


    @Override
    public Pedido findById(Long id) {
        return findPedidoByIdPort.findById(id).orElseThrow(
                () -> new RuntimeException("Não existe um cadastro de pedido com id: " + id)
        );
    }
}
