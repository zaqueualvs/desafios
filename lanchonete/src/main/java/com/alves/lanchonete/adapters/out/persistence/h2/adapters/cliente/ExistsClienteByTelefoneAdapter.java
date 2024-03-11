package com.alves.lanchonete.adapters.out.persistence.h2.adapters.cliente;

import com.alves.lanchonete.adapters.out.persistence.h2.repositories.ClienteRespository;
import com.alves.lanchonete.applications.ports.out.cliente.ExistsClienteByTelefonePort;
import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class ExistsClienteByTelefoneAdapter implements ExistsClienteByTelefonePort {
    private final ClienteRespository clienteRespository;

    @Override
    public Boolean existsByTelefone(String telefone) {
        return clienteRespository.existsByTelefone(telefone);
    }
}
