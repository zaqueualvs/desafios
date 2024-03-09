package com.alves.lanchonete.adapters.in.rest.data.response;

import com.alves.lanchonete.domain.models.enuns.PedidoStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PedidoFullResponse {
    private Long id;
    private Set<ProdutoResponse> produtos;
    private OffsetDateTime dataCriacao;
    private PedidoStatus status;
    private ClienteResponse cliente;
}
