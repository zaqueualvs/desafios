package com.alves.lanchonete.cliente.adapters.out.persistence.h2.adapters;

import com.alves.lanchonete.cliente.adapters.out.persistence.h2.entities.ClienteEntity;
import com.alves.lanchonete.cliente.adapters.out.persistence.h2.mappers.ClientePersistenceMapper;
import com.alves.lanchonete.cliente.adapters.out.persistence.h2.repositories.ClienteRespository;
import com.alves.lanchonete.cliente.applications.ports.out.FindClienteByIdPort;
import com.alves.lanchonete.cliente.domain.models.Cliente;
import com.alves.lanchonete.commons.customannotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class FindClienteByIdAdapter implements FindClienteByIdPort {
    private final ClienteRespository clienteRespository;
    private final ClientePersistenceMapper clientePersistenceMapper;

    @Override
    public Optional<Cliente> findById(Long id) {
        Optional<ClienteEntity> clienteEntityO = clienteRespository.findById(id);
        if (clienteEntityO.isEmpty()) {
            return Optional.empty();
        }
        Cliente cliente = clientePersistenceMapper.toDomain(clienteEntityO.get());
        return Optional.of(cliente);
    }
}
