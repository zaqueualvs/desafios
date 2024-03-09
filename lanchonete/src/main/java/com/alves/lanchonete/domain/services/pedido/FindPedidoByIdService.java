package com.alves.lanchonete.domain.services.pedido;

import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.applications.ports.in.pedido.FindPedidoByIdUseCase;
import com.alves.lanchonete.applications.ports.out.pedido.FindPedidoByIdPort;
import com.alves.lanchonete.domain.models.Pedido;
import lombok.RequiredArgsConstructor;

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
