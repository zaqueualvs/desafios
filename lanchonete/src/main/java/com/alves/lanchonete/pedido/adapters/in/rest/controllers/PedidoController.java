package com.alves.lanchonete.pedido.adapters.in.rest.controllers;

import com.alves.lanchonete.pedido.adapters.in.rest.data.request.PedidoDeleteRequest;
import com.alves.lanchonete.pedido.adapters.in.rest.data.request.PedidoRequest;
import com.alves.lanchonete.pedido.adapters.in.rest.data.response.PedidoResponse;
import com.alves.lanchonete.pedido.adapters.in.rest.mappers.PedidoRestMapper;
import com.alves.lanchonete.pedido.application.ports.in.DeletePedidoByIdUseCase;
import com.alves.lanchonete.pedido.application.ports.in.SavePedidoUseCase;
import com.alves.lanchonete.pedido.domain.models.Pedido;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final SavePedidoUseCase savePedidoUseCase;
    private final DeletePedidoByIdUseCase deletePedidoByIdUseCase;
    private final PedidoRestMapper pedidoRestMapper;

    @PostMapping
    public ResponseEntity<PedidoResponse> save(@RequestBody @Valid PedidoRequest pedidoRequest) {
        Pedido pedido = pedidoRestMapper.toDomain(pedidoRequest);
        pedido = savePedidoUseCase.save(pedido);
        PedidoResponse pedidoResponse = pedidoRestMapper.toResponse(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoResponse);
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody @Valid PedidoDeleteRequest pedidoRequest) {
        Pedido pedido = pedidoRestMapper.toDomain(pedidoRequest);
        deletePedidoByIdUseCase.delete(pedido);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
