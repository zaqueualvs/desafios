package com.alves.lanchonete.applications.ports.out.cliente;

import com.alves.lanchonete.domain.models.Cliente;

public interface ExistsClienteByTelefonePort {

    Boolean existsByTelefone(String telefone);
}
