package com.alves.estacionamento.application.domain.models;

import java.time.OffsetDateTime;


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
}
