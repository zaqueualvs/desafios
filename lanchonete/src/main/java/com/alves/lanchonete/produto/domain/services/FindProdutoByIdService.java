package com.alves.lanchonete.produto.domain.services;

import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.produto.application.in.FindProdutoByIdUseCase;
import com.alves.lanchonete.produto.application.out.FindProdutoByIdPort;
import com.alves.lanchonete.produto.domain.models.Produto;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindProdutoByIdService implements FindProdutoByIdUseCase {
    private final FindProdutoByIdPort findProdutoByIdPort;

    @Override
    public Produto findById(Long id) {
        return findProdutoByIdPort.findById(id).orElseThrow(
                () -> new RuntimeException("Não existe um cadastro de produto com id: " + id)
        );
    }
}
