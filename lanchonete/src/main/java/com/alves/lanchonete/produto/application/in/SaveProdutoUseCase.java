package com.alves.lanchonete.produto.application.in;

import com.alves.lanchonete.produto.domain.models.Produto;

public interface SaveProdutoUseCase {

    Produto save(Produto produto);
}
