package com.alves.lanchonete.adapters.in.rest.controllers;

import com.alves.lanchonete.adapters.in.rest.data.response.ClienteFullResponse;
import com.alves.lanchonete.adapters.in.rest.data.response.ClienteResponse;
import com.alves.lanchonete.adapters.in.rest.mappers.ClienteRestMapper;
import com.alves.lanchonete.adapters.in.rest.data.request.ClienteRequest;
import com.alves.lanchonete.applications.ports.in.cliente.FindClienteByIdUseCase;
import com.alves.lanchonete.applications.ports.in.cliente.SaveClienteUseCase;
import com.alves.lanchonete.domain.models.Cliente;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteRestMapper clienteRestMapper;
    private final FindClienteByIdUseCase findClienteByIdUseCase;
    private final SaveClienteUseCase saveUsuarioUseCase;

    @PostMapping
    public ResponseEntity<ClienteResponse> save(@RequestBody @Valid ClienteRequest clienteRequest) {
        Cliente cliente = clienteRestMapper.toDomain(clienteRequest);
        cliente = saveUsuarioUseCase.save(cliente);
        ClienteResponse clienteResponse = clienteRestMapper.toResponse(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteFullResponse> findById(@PathVariable Long id) {
        Cliente cliente = findClienteByIdUseCase.findById(id);
        ClienteFullResponse clienteFullResponse = clienteRestMapper.toFullResponse(cliente);
        return ResponseEntity.status(HttpStatus.OK).body(clienteFullResponse);
    }
}
