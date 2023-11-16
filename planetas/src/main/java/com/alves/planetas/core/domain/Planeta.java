package com.alves.planetas.core.domain;

import java.io.Serializable;
import java.util.Objects;

public class Planeta implements Serializable {
    private Long id;
    private String nome;

    private String clima;
    private String terreno;

    public Planeta() {
    }

    public Planeta(Long id, String nome, String clima, String terreno) {
        this.id = id;
        this.nome = nome;
        this.clima = clima;
        this.terreno = terreno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planeta planeta = (Planeta) o;
        return Objects.equals(id, planeta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
