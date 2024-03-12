package com.alves.picpaysimplificado.domain.models.enuns;

public enum TipoUsuario {
    COMUM(1, "comum"),
    LOGISTA(2, "logista");

    private Integer cod;
    private String descri;

    TipoUsuario(Integer cod, String descri) {
        this.cod = cod;
        this.descri = descri;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescri() {
        return descri;
    }

    public static TipoUsuario toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (TipoUsuario x : TipoUsuario.values()) {
            if (x.cod.equals(cod)) {
                return x;
            }
        }
        throw new RuntimeException(String.format("Código %d tipo usuario invalido! ", cod));
    }
}
