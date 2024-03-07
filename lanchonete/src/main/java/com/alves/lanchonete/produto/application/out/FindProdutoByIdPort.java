package com.alves.lanchonete.produto.application.out;

import com.alves.lanchonete.produto.domain.models.Produto;

import java.util.Optional;

public interface FindProdutoByIdPort {

    Optional<Produto> findById(Long id);
}
