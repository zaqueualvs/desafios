package com.alves.lanchonete.domain.services.cliente;

import com.alves.lanchonete.applications.ports.in.cliente.SaveClienteUseCase;
import com.alves.lanchonete.applications.ports.out.cliente.ExistClienteByEmailPort;
import com.alves.lanchonete.applications.ports.out.cliente.ExistClienteByTelefonePort;
import com.alves.lanchonete.applications.ports.out.cliente.SaveClientePort;
import com.alves.lanchonete.domain.models.Cliente;
import com.alves.lanchonete.commons.customannotations.UseCase;
import lombok.RequiredArgsConstructor;


@UseCase
@RequiredArgsConstructor
public class SaveClienteService implements SaveClienteUseCase {
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
