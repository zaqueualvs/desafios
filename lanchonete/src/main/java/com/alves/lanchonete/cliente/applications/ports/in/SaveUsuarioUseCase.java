package com.alves.lanchonete.cliente.applications.ports.in;

import com.alves.lanchonete.cliente.domain.models.Cliente;

public interface SaveUsuarioUseCase {

    Cliente save(Cliente cliente);
}
