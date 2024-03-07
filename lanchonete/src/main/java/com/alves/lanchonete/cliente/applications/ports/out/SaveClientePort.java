package com.alves.lanchonete.cliente.applications.ports.out;

import com.alves.lanchonete.cliente.domain.models.Cliente;

public interface SaveClientePort {

    Cliente save(Cliente cliente);
}
