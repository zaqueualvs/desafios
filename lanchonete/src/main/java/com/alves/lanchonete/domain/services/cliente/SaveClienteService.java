package com.alves.lanchonete.domain.services.cliente;

import com.alves.lanchonete.applications.ports.in.cliente.SaveClienteUseCase;
import com.alves.lanchonete.applications.ports.out.cliente.ExistsClienteByEmailPort;
import com.alves.lanchonete.applications.ports.out.cliente.ExistsClienteByTelefonePort;
import com.alves.lanchonete.applications.ports.out.cliente.SaveClientePort;
import com.alves.lanchonete.commons.customannotations.UseCase;
import com.alves.lanchonete.domain.models.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;


@UseCase
@RequiredArgsConstructor
public class SaveClienteService implements SaveClienteUseCase {

    private final SaveClientePort saveClientePort;
    private final ExistsClienteByTelefonePort existsClienteByTelefonePort;
    private final ExistsClienteByEmailPort existsClienteByEmailPort;

    @Override
    public Cliente save(Cliente cliente) {
        validarCliente(cliente);
        return saveClientePort.save(cliente);
    }

    private void validarCliente(Cliente cliente) {
        if (existsClienteByEmailPort.existsByEmail(cliente.getEmail())) {
            throw new DataIntegrityViolationException(
                    String.format("Email %s ja cadastrado", cliente.getEmail())
            );
        }
        if (existsClienteByTelefonePort.existsByTelefone(cliente.getTelefone())) {
            throw new DataIntegrityViolationException(
                    String.format("Telefone %s ja cadastrado", cliente.getTelefone())
            );
        }
    }
}
