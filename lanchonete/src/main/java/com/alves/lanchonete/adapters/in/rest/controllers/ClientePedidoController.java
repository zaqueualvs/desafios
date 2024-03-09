package com.alves.lanchonete.adapters.in.rest.controllers;

import com.alves.lanchonete.adapters.in.rest.data.request.ClientePedidoRequest;
import com.alves.lanchonete.adapters.in.rest.data.request.PedidoRequest;
import com.alves.lanchonete.adapters.in.rest.data.response.PedidoResponse;
import com.alves.lanchonete.adapters.in.rest.mappers.PedidoRestMapper;
import com.alves.lanchonete.applications.ports.in.cliente.FindClienteByIdUseCase;
import com.alves.lanchonete.applications.ports.in.cliente.SaveClienteUseCase;
import com.alves.lanchonete.applications.ports.in.pedido.DeletePedidoByIdUseCase;
import com.alves.lanchonete.applications.ports.in.pedido.FindPedidoByIdUseCase;
import com.alves.lanchonete.applications.ports.in.pedido.SavePedidoUseCase;
import com.alves.lanchonete.domain.models.Cliente;
import com.alves.lanchonete.domain.models.Pedido;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "clientes/{clienteId}")
@RequiredArgsConstructor
public class ClientePedidoController {

    private final SavePedidoUseCase savePedidoUseCase;
    private final DeletePedidoByIdUseCase deletePedidoByIdUseCase;
    private final PedidoRestMapper pedidoRestMapper;

    @PostMapping("/pedidos")
    public ResponseEntity<PedidoResponse> save(@PathVariable Long clienteId,
                                               @RequestBody @Valid PedidoRequest pedidoRequest) {
        pedidoRequest.setCliente(new ClientePedidoRequest(clienteId));
        Pedido pedido = pedidoRestMapper.toDomain(pedidoRequest);
        pedido = savePedidoUseCase.save(pedido);
        PedidoResponse pedidoResponse = pedidoRestMapper.toResponse(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoResponse);
    }

    @DeleteMapping("/pedidos/{pedidoId}")
    public ResponseEntity<Object> delete(@PathVariable Long clienteId,
                                         @PathVariable Long pedidoId) {
        Pedido pedido = new Pedido();
        pedido.setId(pedidoId);
        pedido.setCliente(new Cliente());
        pedido.getCliente().setId(clienteId);
        deletePedidoByIdUseCase.delete(pedido);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
