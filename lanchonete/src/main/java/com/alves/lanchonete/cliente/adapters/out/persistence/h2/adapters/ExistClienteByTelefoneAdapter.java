package com.alves.lanchonete.cliente.adapters.out.persistence.h2.adapters;

import com.alves.lanchonete.cliente.adapters.out.persistence.h2.mappers.ClientePersistenceMapper;
import com.alves.lanchonete.cliente.adapters.out.persistence.h2.repositories.ClienteRespository;
import com.alves.lanchonete.cliente.applications.ports.out.ExistClienteByTelefonePort;
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
