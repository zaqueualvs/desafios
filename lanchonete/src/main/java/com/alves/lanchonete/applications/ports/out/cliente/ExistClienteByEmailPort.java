package com.alves.lanchonete.applications.ports.out.cliente;

public interface ExistClienteByEmailPort {

    Boolean existsByEmail(String email);

}
