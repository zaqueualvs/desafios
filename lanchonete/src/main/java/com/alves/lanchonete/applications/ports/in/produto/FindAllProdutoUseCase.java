package com.alves.lanchonete.applications.ports.in.produto;

import com.alves.lanchonete.domain.models.Produto;

import java.util.List;

public interface FindAllProdutoUseCase {

    List<Produto> findAll();
}
