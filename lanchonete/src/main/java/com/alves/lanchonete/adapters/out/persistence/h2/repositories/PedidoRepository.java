package com.alves.lanchonete.adapters.out.persistence.h2.repositories;

import com.alves.lanchonete.adapters.out.persistence.h2.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
