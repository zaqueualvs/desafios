package com.alves.lanchonete.pedido.adapters.in.rest.data.response;

import com.alves.lanchonete.cliente.adapters.in.rest.data.response.ClienteResponse;
import com.alves.lanchonete.cliente.domain.models.Cliente;
import com.alves.lanchonete.pedido.domain.models.enuns.PedidoStatus;
import com.alves.lanchonete.produto.adapters.in.rest.data.response.ProdutoResponse;
import com.alves.lanchonete.produto.domain.models.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PedidoResponse {
    private Long id;
    private ClienteResponse cliente;
    private ProdutoResponse produto;
    private OffsetDateTime dataCriacao;
    private PedidoStatus status;
}
