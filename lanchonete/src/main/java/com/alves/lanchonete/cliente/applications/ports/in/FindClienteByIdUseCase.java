package com.alves.lanchonete.cliente.applications.ports.in;

import com.alves.lanchonete.cliente.domain.models.Cliente;

import java.util.Optional;

public interface FindClienteByIdUseCase {

    Cliente findById(Long id);
}
