package com.alves.lanchonete.applications.ports.out.produto;

import com.alves.lanchonete.domain.models.Produto;

public interface DeleteProdutoPort {

    void delete(Produto produto);
}
