package com.alves.estacionamento.adapters.out.persistence.h2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class VagaEstacionamentoPKEntity implements Serializable {
    @ManyToOne
    @JoinColumn(name = "estabelecimento_id")
    private EstabelecimentoEntity estabelecimento;
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private VeiculoEntity veiculo;

}
