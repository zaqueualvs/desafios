package com.alves.lanchonete.adapters.out.persistence.h2.adapters.pedido;

import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import com.alves.lanchonete.adapters.out.persistence.h2.entities.PedidoEntity;
import com.alves.lanchonete.adapters.out.persistence.h2.mappers.PedidoPersistenceMapper;
import com.alves.lanchonete.adapters.out.persistence.h2.repositories.PedidoRepository;
import com.alves.lanchonete.applications.ports.out.pedido.SavePedidoPort;
import com.alves.lanchonete.domain.models.Pedido;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class SavePedidoAdapter implements SavePedidoPort {

    private final PedidoRepository pedidoRepository;
    private final PedidoPersistenceMapper pedidoPersistenceMapper;

    @Override
    public Pedido save(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoPersistenceMapper.toEntity(pedido);
        pedidoEntity = pedidoRepository.save(pedidoEntity);
        pedido = pedidoPersistenceMapper.toDomain(pedidoEntity);
        return pedido;
    }
}
