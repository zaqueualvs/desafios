package com.alves.lanchonete.domain.services.pedido;

import com.alves.lanchonete.applications.ports.in.cliente.FindClienteByIdUseCase;
import com.alves.lanchonete.applications.ports.in.pedido.FindAllPedidoByClienteIdUseCase;
import com.alves.lanchonete.applications.ports.out.pedido.FindAllPedidoByClientePort;
import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.domain.models.Cliente;
import com.alves.lanchonete.domain.models.Pedido;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllPedidoByClienteIdService implements FindAllPedidoByClienteIdUseCase {
    private final FindClienteByIdUseCase findClienteByIdUseCase;
    private final FindAllPedidoByClientePort findAllPedidoByClientePort;

    @Override
    public List<Pedido> find(Long id) {
        Cliente cliente = findClienteByIdUseCase.findById(id);
        return findAllPedidoByClientePort.find(cliente);
    }
}
