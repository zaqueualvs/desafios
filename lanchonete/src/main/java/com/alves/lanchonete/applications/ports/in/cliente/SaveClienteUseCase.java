package com.alves.lanchonete.applications.ports.in.cliente;

import com.alves.lanchonete.domain.models.Cliente;

public interface SaveClienteUseCase {

    Cliente save(Cliente cliente);
}
