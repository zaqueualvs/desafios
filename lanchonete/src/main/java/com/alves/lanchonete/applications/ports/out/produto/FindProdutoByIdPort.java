package com.alves.lanchonete.applications.ports.out.produto;

import com.alves.lanchonete.domain.models.Produto;

import java.util.Optional;

public interface FindProdutoByIdPort {

    Optional<Produto> findById(Long id);
}
