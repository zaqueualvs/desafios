package com.alves.lanchonete.pedido.domain.models.enuns;

public enum PedidoStatus {
    PEDENTE(1, "pendente"),
    EM_PREPARO(2, "em preparo"),
    EM_ENTREGA(3, "em entrega"),
    ENTREGUE(4, "entregue"),
    CANCELADO(5, "cancelado");

    private int cod;
    private String descr;

    PedidoStatus(int cod, String descr) {
        this.cod = cod;
        this.descr = descr;
    }
}
