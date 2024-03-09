package com.alves.lanchonete.adapters.out.persistence.h2.repositories;

import com.alves.lanchonete.adapters.out.persistence.h2.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
