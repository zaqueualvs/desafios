package com.alves.lanchonete.pedido.domain.models;

import com.alves.lanchonete.cliente.domain.models.Cliente;
import com.alves.lanchonete.pedido.domain.models.enuns.PedidoStatus;
import com.alves.lanchonete.produto.domain.models.Produto;

import java.time.OffsetDateTime;

public class Pedido {
    private Long id;

    private Cliente cliente;
    private Produto produto;
    private OffsetDateTime dataCriacao;
    private PedidoStatus status;
}
