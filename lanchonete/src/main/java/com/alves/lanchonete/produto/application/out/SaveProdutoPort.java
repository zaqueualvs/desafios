package com.alves.lanchonete.produto.application.out;

import com.alves.lanchonete.produto.domain.models.Produto;

public interface SaveProdutoPort {

    Produto save(Produto produto);
}
