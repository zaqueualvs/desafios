package com.alves.estacionamento.application.domain.models.enums;

public enum TipoVeiculo {
    MOTO(1),
    CARRO(2);

    private Integer cod;

    TipoVeiculo(Integer cod) {
        this.cod = cod;
    }

    public Integer getCod() {
        return cod;
    }

    public static TipoVeiculo toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (TipoVeiculo x : TipoVeiculo.values()) {
            if (x.getCod().equals(cod)) {
                return x;
            }
        }
        throw new RuntimeException("Codigo tipo veiculo invalido");
    }
}
