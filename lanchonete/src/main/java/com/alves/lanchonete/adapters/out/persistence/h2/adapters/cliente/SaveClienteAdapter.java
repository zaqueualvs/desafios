package com.alves.lanchonete.adapters.out.persistence.h2.adapters.cliente;

import com.alves.lanchonete.adapters.out.persistence.h2.mappers.ClientePersistenceMapper;
import com.alves.lanchonete.adapters.out.persistence.h2.entities.ClienteEntity;
import com.alves.lanchonete.adapters.out.persistence.h2.repositories.ClienteRespository;
import com.alves.lanchonete.applications.ports.out.cliente.SaveClientePort;
import com.alves.lanchonete.domain.models.Cliente;
import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class SaveClienteAdapter implements SaveClientePort {

    private final ClienteRespository clienteRespository;
    private final ClientePersistenceMapper clientePersistenceMapper;

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity clienteEntity = clientePersistenceMapper.toEntity(cliente);
        clienteEntity = clienteRespository.save(clienteEntity);
        cliente = clientePersistenceMapper.toDomain(clienteEntity);

        return cliente;
    }
}
