package com.alves.estacionamento.adapters.out.persistence.h2.entities;

import com.alves.estacionamento.application.domain.models.enums.TipoVeiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "veiculo")
public class VeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String cor;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String placa;
    @Column(nullable = false)
    private Integer tipoVeiculo;

    public TipoVeiculo getTipoVeiculo() {
        return TipoVeiculo.toEnum(tipoVeiculo);
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo.getCod();
    }
}
