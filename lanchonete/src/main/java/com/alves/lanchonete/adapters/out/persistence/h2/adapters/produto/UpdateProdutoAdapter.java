package com.alves.lanchonete.adapters.out.persistence.h2.adapters.produto;

import com.alves.lanchonete.applications.ports.out.produto.SaveProdutoPort;
import com.alves.lanchonete.applications.ports.out.produto.UpdateProdutoPort;
import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import com.alves.lanchonete.domain.models.Produto;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UpdateProdutoAdapter implements UpdateProdutoPort {

    private final SaveProdutoPort saveProdutoPort;

    @Override
    public Produto update(Produto produto){
        return saveProdutoPort.save(produto);
    }
}
