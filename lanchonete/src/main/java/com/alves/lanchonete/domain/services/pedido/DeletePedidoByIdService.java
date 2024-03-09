package com.alves.lanchonete.domain.services.pedido;

import com.alves.lanchonete.applications.ports.in.cliente.FindClienteByIdUseCase;
import com.alves.lanchonete.domain.models.Cliente;
import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.applications.ports.in.pedido.DeletePedidoByIdUseCase;
import com.alves.lanchonete.applications.ports.in.pedido.FindPedidoByIdUseCase;
import com.alves.lanchonete.applications.ports.out.pedido.DeletePedidoByIdPort;
import com.alves.lanchonete.domain.models.Pedido;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DeletePedidoByIdService implements DeletePedidoByIdUseCase {

    private final DeletePedidoByIdPort deletePedidoByIdPort;
    private final FindPedidoByIdUseCase findPedidoByIdUseCase;
    private final FindClienteByIdUseCase findClienteByIdUseCase;

    @Override
    public void delete(Pedido pedido) {
        Pedido pedidoToDelete = findPedidoByIdUseCase.findById(pedido.getId());
        Cliente cliente = findClienteByIdUseCase.findById(pedido.getCliente().getId());
        if (!pedidoToDelete.getCliente().equals(cliente)) {
            throw new IllegalArgumentException("Pedido não pode ser removido. Esse cliente não criou esse pedido");
        }
        deletePedidoByIdPort.delete(pedidoToDelete);
    }
}
