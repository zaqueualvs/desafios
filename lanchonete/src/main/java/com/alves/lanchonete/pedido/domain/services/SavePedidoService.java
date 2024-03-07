package com.alves.lanchonete.pedido.domain.services;

import com.alves.lanchonete.cliente.applications.ports.in.FindClienteByIdUseCase;
import com.alves.lanchonete.cliente.domain.models.Cliente;
import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.pedido.application.ports.in.SavePedidoUseCase;
import com.alves.lanchonete.pedido.application.ports.out.SavePedidoPort;
import com.alves.lanchonete.pedido.domain.models.Pedido;
import com.alves.lanchonete.produto.application.in.FindProdutoByIdUseCase;
import com.alves.lanchonete.produto.domain.models.Produto;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SavePedidoService implements SavePedidoUseCase {

    private final SavePedidoPort savePedidoPort;
    private final FindClienteByIdUseCase findClienteByIdUseCase;
    private final FindProdutoByIdUseCase findProdutoByIdUseCase;

    @Override
    public Pedido save(Pedido pedido) {
        Cliente cliente = findClienteByIdUseCase.findById(pedido.getCliente().getId());
        Produto produto = findProdutoByIdUseCase.findById(pedido.getProduto().getId());
        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        return savePedidoPort.save(pedido);
    }
}