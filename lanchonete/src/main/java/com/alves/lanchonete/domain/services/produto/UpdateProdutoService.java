package com.alves.lanchonete.domain.services.produto;

import com.alves.lanchonete.applications.ports.in.produto.UpdateProdutoUseCase;
import com.alves.lanchonete.applications.ports.out.produto.UpdateProdutoPort;
import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.domain.models.Produto;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateProdutoService implements UpdateProdutoUseCase {

    private final UpdateProdutoPort updateProdutoPort;

    @Override
    public Produto update(Produto produto) {
        return updateProdutoPort.update(produto);
    }
}
