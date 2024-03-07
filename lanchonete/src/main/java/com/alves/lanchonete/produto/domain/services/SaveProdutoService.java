package com.alves.lanchonete.produto.domain.services;

import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.produto.application.in.SaveProdutoUseCase;
import com.alves.lanchonete.produto.application.out.SaveProdutoPort;
import com.alves.lanchonete.produto.domain.models.Produto;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SaveProdutoService implements SaveProdutoUseCase {

    private final SaveProdutoPort saveProdutoPort;

    @Override
    public Produto save(Produto produto) {
        return saveProdutoPort.save(produto);
    }
}
