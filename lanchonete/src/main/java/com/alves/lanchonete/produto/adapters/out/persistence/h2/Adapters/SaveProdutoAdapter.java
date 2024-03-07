package com.alves.lanchonete.produto.adapters.out.persistence.h2.Adapters;

import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import com.alves.lanchonete.produto.adapters.out.persistence.h2.entities.ProdutoEntity;
import com.alves.lanchonete.produto.adapters.out.persistence.h2.mappers.ProdutoPersistenceMapper;
import com.alves.lanchonete.produto.adapters.out.persistence.h2.repositories.ProdutoRepository;
import com.alves.lanchonete.produto.application.out.SaveProdutoPort;
import com.alves.lanchonete.produto.domain.models.Produto;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class SaveProdutoAdapter implements SaveProdutoPort {

    private final ProdutoRepository produtoRepository;
    private final ProdutoPersistenceMapper produtoPersistenceMapper;

    @Override
    public Produto save(Produto produto) {
        ProdutoEntity produtoEntity = produtoPersistenceMapper.toEntity(produto);
        produtoEntity = produtoRepository.save(produtoEntity);
        produto = produtoPersistenceMapper.toDomain(produtoEntity);
        return produto;
    }
}
