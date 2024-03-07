package com.alves.lanchonete.pedido.adapters.out.persistence.h2.adapters;

import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import com.alves.lanchonete.pedido.adapters.out.persistence.h2.entities.PedidoEntity;
import com.alves.lanchonete.pedido.adapters.out.persistence.h2.mappers.PedidoPersistenceMapper;
import com.alves.lanchonete.pedido.adapters.out.persistence.h2.repositories.PedidoRepository;
import com.alves.lanchonete.pedido.application.ports.out.FindPedidoByIdPort;
import com.alves.lanchonete.pedido.domain.models.Pedido;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindPedidoByIdAdapter implements FindPedidoByIdPort {
    private final PedidoRepository pedidoRepository;
    private final PedidoPersistenceMapper pedidoPersistenceMapper;

    @Override
    public Optional<Pedido> findById(Long id) {
        Optional<PedidoEntity> pedidoEntityO = pedidoRepository.findById(id);
        if (pedidoEntityO.isEmpty()) {
            return Optional.empty();
        }
        Pedido pedido = pedidoPersistenceMapper.toDomain(pedidoEntityO.get());
        return Optional.of(pedido);
    }
}
