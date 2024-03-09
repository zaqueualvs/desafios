package com.alves.lanchonete.adapters.out.persistence.h2.adapters.pedido;

import com.alves.lanchonete.adapters.out.persistence.h2.mappers.ClientePersistenceMapper;
import com.alves.lanchonete.adapters.out.persistence.h2.mappers.PedidoPersistenceMapper;
import com.alves.lanchonete.adapters.out.persistence.h2.repositories.PedidoRepository;
import com.alves.lanchonete.applications.ports.out.pedido.FindAllPedidoByClientePort;
import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import com.alves.lanchonete.domain.models.Cliente;
import com.alves.lanchonete.domain.models.Pedido;
import lombok.RequiredArgsConstructor;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindAllPedidoByClienteAdapter implements FindAllPedidoByClientePort {

    private final PedidoPersistenceMapper pedidoPersistenceMapper;
    private final ClientePersistenceMapper clientePersistenceMapper;
    private final PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> find(Cliente cliente) {
        return pedidoRepository.findAllByCliente(clientePersistenceMapper.toEntity(cliente))
                .stream()
                .map(pedidoPersistenceMapper::toDomain)
                .toList();
    }
}
