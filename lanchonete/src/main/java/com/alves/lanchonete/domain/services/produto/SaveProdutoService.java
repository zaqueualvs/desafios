package com.alves.lanchonete.domain.services.produto;

import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.applications.ports.in.produto.SaveProdutoUseCase;
import com.alves.lanchonete.applications.ports.out.produto.SaveProdutoPort;
import com.alves.lanchonete.domain.models.Produto;
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
