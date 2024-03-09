package com.alves.lanchonete.applications.ports.out.cliente;

import com.alves.lanchonete.domain.models.Cliente;

import java.util.Optional;

public interface FindClienteByIdPort {

    Optional<Cliente> findById(Long id);
}
