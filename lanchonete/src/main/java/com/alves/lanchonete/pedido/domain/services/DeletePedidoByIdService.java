package com.alves.lanchonete.pedido.domain.services;

import com.alves.lanchonete.cliente.applications.ports.in.FindClienteByIdUseCase;
import com.alves.lanchonete.cliente.domain.models.Cliente;
import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.pedido.application.ports.in.DeletePedidoByIdUseCase;
import com.alves.lanchonete.pedido.application.ports.in.FindPedidoByIdUseCase;
import com.alves.lanchonete.pedido.application.ports.out.DeletePedidoByIdPort;
import com.alves.lanchonete.pedido.domain.models.Pedido;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DeletePedidoByIdService implements DeletePedidoByIdUseCase {

    private final FindClienteByIdUseCase findClienteByIdUseCase;
    private final DeletePedidoByIdPort deletePedidoByIdPort;
    private final FindPedidoByIdUseCase findPedidoByIdUseCase;

    @Override
    public void delete(Pedido pedido) {
        Cliente cliente = findClienteByIdUseCase.findById(pedido.getCliente().getId());
        Pedido pedidoToDelete = findPedidoByIdUseCase.findById(pedido.getId());

        if (!(pedidoToDelete.getCliente().equals(cliente))) {
            throw new RuntimeException("Pedido não pode ser removido por vocẽ não ser o cliente que criou ele");
        }
        deletePedidoByIdPort.delete(pedidoToDelete);
    }
}
