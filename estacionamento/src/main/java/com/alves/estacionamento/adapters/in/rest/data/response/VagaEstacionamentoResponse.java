package com.alves.estacionamento.adapters.in.rest.data.response;

import com.alves.estacionamento.adapters.out.persistence.h2.entities.EstabelecimentoEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.entities.VagaEstacionamentoPKEntity;
import com.alves.estacionamento.adapters.out.persistence.h2.entities.VeiculoEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;


@NoArgsConstructor
@Getter
@Setter

public class VagaEstacionamentoResponse {
    private VeiculoResponse veiculo;
    private OffsetDateTime dataEntrada;
}
