package com.alves.lanchonete.domain.services.cliente;

import com.alves.lanchonete.applications.ports.in.cliente.FindClienteByIdUseCase;
import com.alves.lanchonete.applications.ports.out.cliente.FindClienteByIdPort;
import com.alves.lanchonete.domain.models.Cliente;
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
