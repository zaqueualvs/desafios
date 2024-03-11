package com.alves.lanchonete.adapters.out.persistence.h2.adapters.cliente;

import com.alves.lanchonete.adapters.out.persistence.h2.repositories.ClienteRespository;
import com.alves.lanchonete.applications.ports.out.cliente.ExistsClienteByEmailPort;
import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class ExistsClienteByEmailAdapter implements ExistsClienteByEmailPort {

    private final ClienteRespository clienteRespository;

    @Override
    public Boolean existsByEmail(String email){
        return clienteRespository.existsByEmail(email);
    }
}
