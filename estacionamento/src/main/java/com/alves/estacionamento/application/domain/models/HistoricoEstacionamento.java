package com.alves.estacionamento.application.domain.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.PreUpdate;

import java.time.OffsetDateTime;


public class HistoricoEstacionamento {
    private Long id;
    private Estabelecimento estabelecimento;
    private Veiculo veiculo;
    private OffsetDateTime dataEntrada;
    private OffsetDateTime dataSaida;

    public HistoricoEstacionamento() {
    }

    public HistoricoEstacionamento(Long id,
                                   Estabelecimento estabelecimento,
                                   Veiculo veiculo,
                                   OffsetDateTime dataEntrada,
                                   OffsetDateTime dataSaida) {
        this.id = id;
        this.estabelecimento = estabelecimento;
        this.veiculo = veiculo;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public OffsetDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(OffsetDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }
}
