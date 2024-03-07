package com.alves.lanchonete.pedido.adapters.out.persistence.h2.adapters;

import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import com.alves.lanchonete.pedido.adapters.out.persistence.h2.entities.PedidoEntity;
import com.alves.lanchonete.pedido.adapters.out.persistence.h2.mappers.PedidoPersistenceMapper;
import com.alves.lanchonete.pedido.adapters.out.persistence.h2.repositories.PedidoRepository;
import com.alves.lanchonete.pedido.application.ports.out.DeletePedidoByIdPort;
import com.alves.lanchonete.pedido.domain.models.Pedido;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class DeletePedidoByIdAdapter implements DeletePedidoByIdPort {

    private final PedidoRepository pedidoRepository;
    private final PedidoPersistenceMapper pedidoPersistenceMapper;

    @Override
    public void delete(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoPersistenceMapper.toEntity(pedido);
        pedidoRepository.delete(pedidoEntity);
    }
}
