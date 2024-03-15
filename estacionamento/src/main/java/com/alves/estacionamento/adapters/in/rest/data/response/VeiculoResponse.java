package com.alves.estacionamento.adapters.in.rest.data.response;

import com.alves.estacionamento.application.domain.models.enums.TipoVeiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class VeiculoResponse {

    private Long id;
    private String modelo;
    private String cor;
    private String marca;
    private String placa;
    private TipoVeiculo tipoVeiculo;
}
