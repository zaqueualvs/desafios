package com.alves.lanchonete.adapters.out.persistence.h2.adapters.cliente;

import com.alves.lanchonete.adapters.out.persistence.h2.repositories.ClienteRespository;
import com.alves.lanchonete.applications.ports.out.cliente.ExistClienteByTelefonePort;
import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class ExistClienteByTelefoneAdapter implements ExistClienteByTelefonePort {
    private final ClienteRespository clienteRespository;

    @Override
    public Boolean existsByTelefone(String telefone) {
        return clienteRespository.existsByTelefone(telefone);
    }
}
