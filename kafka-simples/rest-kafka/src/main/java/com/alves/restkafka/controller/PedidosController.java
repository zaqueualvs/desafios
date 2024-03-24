package com.alves.restkafka.controller;

import com.alves.restkafka.kafka.data.PedidoData;
import com.alves.restkafka.services.RegistraEventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidosController {

    private final RegistraEventoService registraEventoService;

    @PostMapping
    public ResponseEntity<String> salvarPedido(@RequestBody PedidoData pedidoData) {
        registraEventoService.adicionarEvento("SalvarPedido", pedidoData);
        return ResponseEntity.ok().body("Sucesso");
    }
}
