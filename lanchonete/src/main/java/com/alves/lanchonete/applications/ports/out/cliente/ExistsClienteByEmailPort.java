package com.alves.lanchonete.applications.ports.out.cliente;

import com.alves.lanchonete.domain.models.Cliente;

public interface ExistsClienteByEmailPort {

    Boolean existsByEmail(String email);
}
