package com.alves.lanchonete.applications.ports.out.cliente;

public interface ExistClienteByTelefonePort {

    Boolean existsByTelefone(String telefone);
}
