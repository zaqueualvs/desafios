package com.alves.estacionamento.adapters.in.rest.data.request;

import com.alves.estacionamento.adapters.in.rest.data.response.VeiculoResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class VagaEstacionamentoResquest {
    private Long veiculoId;
    private Long estabelecimentoId;
}
