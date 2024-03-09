package com.alves.lanchonete.adapters.out.persistence.h2.adapters.pedido;

import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import com.alves.lanchonete.adapters.out.persistence.h2.entities.PedidoEntity;
import com.alves.lanchonete.adapters.out.persistence.h2.mappers.PedidoPersistenceMapper;
import com.alves.lanchonete.adapters.out.persistence.h2.repositories.PedidoRepository;
import com.alves.lanchonete.applications.ports.out.pedido.FindPedidoByIdPort;
import com.alves.lanchonete.domain.models.Pedido;
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
