package com.alves.lanchonete.cliente.domain.services;

import com.alves.lanchonete.cliente.applications.ports.in.FindClienteByIdUseCase;
import com.alves.lanchonete.cliente.applications.ports.out.FindClienteByIdPort;
import com.alves.lanchonete.cliente.domain.models.Cliente;
import com.alves.lanchonete.commons.customannotations.UseCase;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindClienteByIdService implements FindClienteByIdUseCase {

    private final FindClienteByIdPort findClienteByIdPort;

    @Override
    public Cliente findById(Long id) {
        return findClienteByIdPort.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Não existe um cadastro de cliente com id " + id)
        );
    }
}
