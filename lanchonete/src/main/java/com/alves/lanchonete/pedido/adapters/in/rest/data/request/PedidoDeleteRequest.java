package com.alves.lanchonete.pedido.adapters.in.rest.data.request;

import com.alves.lanchonete.pedido.domain.models.enuns.PedidoStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PedidoDeleteRequest {
    private Long id;
    private Long clienteId;
}
