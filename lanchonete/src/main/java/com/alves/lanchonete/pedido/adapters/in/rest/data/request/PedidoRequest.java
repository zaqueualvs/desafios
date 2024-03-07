package com.alves.lanchonete.pedido.adapters.in.rest.data.request;

import com.alves.lanchonete.cliente.domain.models.Cliente;
import com.alves.lanchonete.pedido.domain.models.enuns.PedidoStatus;
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
public class PedidoRequest {
    private Long clienteId;
    private Long produtoId;
    private PedidoStatus status;


    public void setStatus(Integer status) {
        this.status = PedidoStatus.toEnum(status);
    }
}
