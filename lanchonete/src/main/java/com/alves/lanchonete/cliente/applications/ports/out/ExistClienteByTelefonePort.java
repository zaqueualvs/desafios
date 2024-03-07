package com.alves.lanchonete.cliente.applications.ports.out;

public interface ExistClienteByTelefonePort {

    Boolean existsByTelefone(String telefone);
}
