package com.alves.lanchonete.applications.ports.out.produto;

import com.alves.lanchonete.domain.models.Produto;

import java.util.List;

public interface FindAllProdutoPort {

    List<Produto> findAll();
}
