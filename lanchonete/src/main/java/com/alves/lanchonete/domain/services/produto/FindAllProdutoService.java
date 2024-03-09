package com.alves.lanchonete.domain.services.produto;

import com.alves.lanchonete.applications.ports.in.produto.FindAllProdutoUseCase;
import com.alves.lanchonete.applications.ports.out.produto.FindAllProdutoPort;
import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.domain.models.Produto;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllProdutoService implements FindAllProdutoUseCase {

    private final FindAllProdutoPort findAllProdutoPort;

    @Override
    public List<Produto> findAll() {
        return findAllProdutoPort.findAll();
    }
}
