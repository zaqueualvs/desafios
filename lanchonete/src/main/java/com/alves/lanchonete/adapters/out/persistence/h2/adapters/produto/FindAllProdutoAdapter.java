package com.alves.lanchonete.adapters.out.persistence.h2.adapters.produto;

import com.alves.lanchonete.adapters.out.persistence.h2.mappers.ProdutoPersistenceMapper;
import com.alves.lanchonete.adapters.out.persistence.h2.repositories.ProdutoRepository;
import com.alves.lanchonete.applications.ports.out.produto.FindAllProdutoPort;
import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import com.alves.lanchonete.domain.models.Produto;
import lombok.AllArgsConstructor;

import java.util.List;

@PersistenceAdapter
@AllArgsConstructor
public class FindAllProdutoAdapter implements FindAllProdutoPort {

    private final ProdutoRepository produtoRepository;
    private final ProdutoPersistenceMapper produtoPersistenceMapper;

    public List<Produto> findAll() {
        return produtoRepository.findAll().stream()
                .map(produtoPersistenceMapper::toDomain)
                .toList();
    }
}
