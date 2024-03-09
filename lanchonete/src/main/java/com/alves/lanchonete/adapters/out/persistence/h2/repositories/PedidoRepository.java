package com.alves.lanchonete.adapters.out.persistence.h2.repositories;

import com.alves.lanchonete.adapters.out.persistence.h2.entities.ClienteEntity;
import com.alves.lanchonete.adapters.out.persistence.h2.entities.PedidoEntity;
import com.alves.lanchonete.domain.models.Cliente;
import com.alves.lanchonete.domain.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findAllByCliente(ClienteEntity cliente);
}
