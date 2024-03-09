package com.alves.lanchonete.domain.services.pedido;

import com.alves.lanchonete.applications.ports.in.cliente.FindClienteByIdUseCase;
import com.alves.lanchonete.domain.models.Cliente;
import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.applications.ports.in.pedido.SavePedidoUseCase;
import com.alves.lanchonete.applications.ports.out.pedido.SavePedidoPort;
import com.alves.lanchonete.domain.models.Pedido;
import com.alves.lanchonete.applications.ports.in.produto.FindProdutoByIdUseCase;
import com.alves.lanchonete.domain.models.Produto;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
public class SavePedidoService implements SavePedidoUseCase {

    private final SavePedidoPort savePedidoPort;
    private final FindClienteByIdUseCase findClienteByIdUseCase;
    private final FindProdutoByIdUseCase findProdutoByIdUseCase;

    @Override
    public Pedido save(Pedido pedido) {

        Cliente cliente = findClienteByIdUseCase.findById(pedido.getCliente().getId());
        pedido.setCliente(cliente);
        Set<Produto> produtos = pedido.getProdutos().stream()
                .map(produto -> findProdutoByIdUseCase.findById(produto.getId()))
                .collect(Collectors.toSet());
        pedido.setProdutos(produtos);

        return savePedidoPort.save(pedido);
    }
}