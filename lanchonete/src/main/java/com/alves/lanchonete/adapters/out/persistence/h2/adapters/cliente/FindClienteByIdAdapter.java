package com.alves.lanchonete.adapters.out.persistence.h2.adapters.cliente;

import com.alves.lanchonete.adapters.out.persistence.h2.mappers.ClientePersistenceMapper;
import com.alves.lanchonete.adapters.out.persistence.h2.entities.ClienteEntity;
import com.alves.lanchonete.adapters.out.persistence.h2.repositories.ClienteRespository;
import com.alves.lanchonete.applications.ports.out.cliente.FindClienteByIdPort;
import com.alves.lanchonete.domain.models.Cliente;
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
