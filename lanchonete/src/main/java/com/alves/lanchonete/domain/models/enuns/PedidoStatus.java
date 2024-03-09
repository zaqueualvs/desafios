package com.alves.lanchonete.domain.models.enuns;

public enum PedidoStatus {
    PEDENTE(1, "pendente"),
    EM_PREPARO(2, "em preparo"),
    EM_ENTREGA(3, "em entrega"),
    ENTREGUE(4, "entregue"),
    CANCELADO(5, "cancelado");

    private Integer cod;
    private String descr;

    PedidoStatus(Integer cod, String descr) {
        this.cod = cod;
        this.descr = descr;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescr() {
        return descr;
    }

    public static PedidoStatus toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (PedidoStatus x : PedidoStatus.values()) {
            if (x.getCod().equals(cod)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Codigo invalido: " + cod);
    }
}
