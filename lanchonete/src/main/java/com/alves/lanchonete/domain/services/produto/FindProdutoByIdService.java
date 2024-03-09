package com.alves.lanchonete.domain.services.produto;

import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.applications.ports.in.produto.FindProdutoByIdUseCase;
import com.alves.lanchonete.applications.ports.out.produto.FindProdutoByIdPort;
import com.alves.lanchonete.domain.models.Produto;
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
