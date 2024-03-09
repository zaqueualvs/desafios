package com.alves.lanchonete.adapters.out.persistence.h2.adapters.produto;

import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import com.alves.lanchonete.adapters.out.persistence.h2.entities.ProdutoEntity;
import com.alves.lanchonete.adapters.out.persistence.h2.mappers.ProdutoPersistenceMapper;
import com.alves.lanchonete.adapters.out.persistence.h2.repositories.ProdutoRepository;
import com.alves.lanchonete.applications.ports.out.produto.FindProdutoByIdPort;
import com.alves.lanchonete.domain.models.Produto;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindProdutoByIdAdapter implements FindProdutoByIdPort {
    private final ProdutoRepository produtoRepository;
    private final ProdutoPersistenceMapper produtoPersistenceMapper;

    @Override
    public Optional<Produto> findById(Long id) {
        Optional<ProdutoEntity> produtoEntityO = produtoRepository.findById(id);
        if (produtoEntityO.isEmpty()) {
            return Optional.empty();
        }
        Produto produto = produtoPersistenceMapper.toDomain(produtoEntityO.get());
        return Optional.of(produto);
    }
}
