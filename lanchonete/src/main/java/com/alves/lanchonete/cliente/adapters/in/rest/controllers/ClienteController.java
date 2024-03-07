package com.alves.lanchonete.cliente.adapters.in.rest.controllers;

import com.alves.lanchonete.cliente.adapters.in.rest.data.request.ClienteRequest;
import com.alves.lanchonete.cliente.adapters.in.rest.data.response.ClienteResponse;
import com.alves.lanchonete.cliente.adapters.in.rest.mappers.ClienteRestMapper;
import com.alves.lanchonete.cliente.applications.ports.in.SaveUsuarioUseCase;
import com.alves.lanchonete.cliente.domain.models.Cliente;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteRestMapper clienteRestMapper;
    private final SaveUsuarioUseCase saveUsuarioUseCase;

    @PostMapping
    public ResponseEntity<ClienteResponse> save(@RequestBody @Valid ClienteRequest clienteRequest){
        Cliente cliente = clienteRestMapper.toDomain(clienteRequest);
        cliente = saveUsuarioUseCase.save(cliente);
        ClienteResponse clienteResponse = clienteRestMapper.toResponse(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);
    }
}
