package com.alves.lanchonete.cliente.applications.ports.out;

import com.alves.lanchonete.cliente.domain.models.Cliente;

import java.util.Optional;

public interface FindClienteByIdPort {

    Optional<Cliente> findById(Long id);
}
