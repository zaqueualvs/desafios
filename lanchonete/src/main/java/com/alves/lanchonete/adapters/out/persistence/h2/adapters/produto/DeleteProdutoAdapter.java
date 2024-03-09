package com.alves.lanchonete.adapters.out.persistence.h2.adapters.produto;

import com.alves.lanchonete.adapters.out.persistence.h2.entities.ProdutoEntity;
import com.alves.lanchonete.adapters.out.persistence.h2.mappers.ProdutoPersistenceMapper;
import com.alves.lanchonete.adapters.out.persistence.h2.repositories.ProdutoRepository;
import com.alves.lanchonete.applications.ports.out.produto.DeleteProdutoPort;
import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import com.alves.lanchonete.domain.models.Produto;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class DeleteProdutoAdapter implements DeleteProdutoPort {

    private final ProdutoRepository produtoRepository;
    private final ProdutoPersistenceMapper produtoPersistenceMapper;

    @Override
    public void delete(Produto produto) {
        ProdutoEntity produtoEntity = produtoPersistenceMapper.toEntity(produto);
        produtoRepository.delete(produtoEntity);
    }
}
