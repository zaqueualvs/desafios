package com.alves.lanchonete.adapters.in.rest.data.request;

import com.alves.lanchonete.domain.models.enuns.PedidoStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PedidoRequest {
    private Set<ProdutoPedidoRequest> produtos;
    private PedidoStatus status;
    private ClientePedidoRequest cliente;

    public void setStatus(Integer status) {
        this.status = PedidoStatus.toEnum(status);
    }
}
