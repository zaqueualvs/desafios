package com.alves.estacionamento.application.domain.models;

import java.time.OffsetDateTime;
import java.util.Objects;


public class VagaEstacionamento {

    private Estabelecimento estabelecimento;
    private Veiculo veiculo;
    private OffsetDateTime dataEntrada;

    public VagaEstacionamento() {
    }

    public VagaEstacionamento(Estabelecimento estabelecimento, Veiculo veiculo, OffsetDateTime dataEntrada) {
        this.estabelecimento = estabelecimento;
        this.veiculo = veiculo;
        this.dataEntrada = dataEntrada;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public OffsetDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(OffsetDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VagaEstacionamento that = (VagaEstacionamento) o;
        return Objects.equals(estabelecimento, that.estabelecimento) && Objects.equals(veiculo, that.veiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estabelecimento, veiculo);
    }
}
