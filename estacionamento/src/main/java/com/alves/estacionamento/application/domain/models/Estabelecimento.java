package com.alves.estacionamento.application.domain.models;

import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Estabelecimento {
    private Long id;
    private String cnpj;
    private String endereco;
    private String telefone;
    private Integer totalVagasMotos;
    private Integer totalVagasCarros;

    private Set<VagaEstacionamento> vagasUsada = new HashSet<>();

    public Estabelecimento() {
    }

    public Estabelecimento(Long id, String cnpj, String endereco, String telefone, Integer totalVagasMotos, Integer totalVagasCarros) {
        this.id = id;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.totalVagasMotos = totalVagasMotos;
        this.totalVagasCarros = totalVagasCarros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getTotalVagasMotos() {
        return totalVagasMotos;
    }

    public void setTotalVagasMotos(Integer totalVagasMotos) {
        this.totalVagasMotos = totalVagasMotos;
    }

    public Integer getTotalVagasCarros() {
        return totalVagasCarros;
    }

    public void setTotalVagasCarros(Integer totalVagasCarros) {
        this.totalVagasCarros = totalVagasCarros;

    }

    public Set<VagaEstacionamento> getVagasUsada() {
        return vagasUsada;
    }

    public void setVagasUsada(Set<VagaEstacionamento> vagasUsada) {
        this.vagasUsada = vagasUsada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estabelecimento that = (Estabelecimento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
