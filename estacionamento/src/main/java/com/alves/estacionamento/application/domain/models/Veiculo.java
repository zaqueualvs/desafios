package com.alves.estacionamento.application.domain.models;

import com.alves.estacionamento.application.domain.models.enums.TipoVeiculo;

public class Veiculo {

    private Long id;
    private String modelo;
    private String cor;
    private String marca;
    private String placa;
    private TipoVeiculo tipoVeiculo;

    public Veiculo() {
    }

    public Veiculo(Long id, String modelo, String cor, String marca, String placa, TipoVeiculo tipoVeiculo) {
        this.id = id;
        this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.placa = placa;
        this.tipoVeiculo = tipoVeiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }
}
