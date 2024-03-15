package com.alves.estacionamento.adapters.out.persistence.h2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "historico_estacionamento")
public class HistoricoEstacionamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private VeiculoEntity veiculo;
    @OneToOne
    private EstabelecimentoEntity estabelecimento;
    private OffsetDateTime dataEntrada;
    private OffsetDateTime dataSaida;

}
