package com.alves.lanchonete.cliente.domain.services;

import com.alves.lanchonete.cliente.applications.ports.in.SaveUsuarioUseCase;
import com.alves.lanchonete.cliente.applications.ports.out.ExistClienteByEmailPort;
import com.alves.lanchonete.cliente.applications.ports.out.ExistClienteByTelefonePort;
import com.alves.lanchonete.cliente.applications.ports.out.SaveClientePort;
import com.alves.lanchonete.cliente.domain.models.Cliente;
import com.alves.lanchonete.commons.customannotations.UseCase;
import lombok.RequiredArgsConstructor;


@UseCase
@RequiredArgsConstructor
public class SaveClienteService implements SaveUsuarioUseCase {
    private final ExistClienteByEmailPort existClienteByEmailPort;
    private final ExistClienteByTelefonePort existClienteByTelefonePort;
    private final SaveClientePort saveClientePort;

    @Override
    public Cliente save(Cliente cliente) {
        if (existClienteByEmailPort.existsByEmail(cliente.getEmail())) {
            throw new RuntimeException("Email " + cliente.getEmail() + " ja cadastrado");
        }
        if (existClienteByTelefonePort.existsByTelefone(cliente.getTelefone())) {
            throw new RuntimeException("Telefone " + cliente.getTelefone() + " ja cadastrado");
        }
        return saveClientePort.save(cliente);
    }
}
