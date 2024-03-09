package com.alves.lanchonete.domain.services.produto;

import com.alves.lanchonete.applications.ports.in.produto.DeleteProdutoByIdUseCase;
import com.alves.lanchonete.applications.ports.in.produto.FindProdutoByIdUseCase;
import com.alves.lanchonete.applications.ports.out.produto.DeleteProdutoPort;
import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.domain.models.Produto;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DeleteProdutoByIdService implements DeleteProdutoByIdUseCase {

    private final DeleteProdutoPort deleteProdutoPort;
    private final FindProdutoByIdUseCase findProdutoByIdUseCase;

    @Override
    public void delete(Long id) {
        Produto produto = findProdutoByIdUseCase.findById(id);
        deleteProdutoPort.delete(produto);
    }
}
