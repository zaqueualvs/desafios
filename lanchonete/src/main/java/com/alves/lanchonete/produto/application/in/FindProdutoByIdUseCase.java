package com.alves.lanchonete.produto.application.in;

import com.alves.lanchonete.produto.domain.models.Produto;

public interface FindProdutoByIdUseCase {

    Produto findById(Long id);
}
