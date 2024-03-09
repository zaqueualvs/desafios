package com.alves.lanchonete.applications.ports.in.produto;

import com.alves.lanchonete.domain.models.Produto;

public interface DeleteProdutoByIdUseCase {

    void delete(Long id);
}
