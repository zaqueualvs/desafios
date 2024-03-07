package com.alves.lanchonete.cliente.applications.ports.out;

public interface ExistClienteByEmailPort {

    Boolean existsByEmail(String email);

}
