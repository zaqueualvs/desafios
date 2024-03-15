package com.alves.estacionamento.adapters.out.persistence.h2.entities;

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
@Entity
@Table(name = "vaga_estacionamento")
public class VagaEstacionamentoEntity {
    @EmbeddedId
    private VagaEstacionamentoPKEntity id = new VagaEstacionamentoPKEntity();
    private OffsetDateTime dataEntrada;

    public VagaEstacionamentoEntity(EstabelecimentoEntity estabelecimento,
                                    VeiculoEntity veiculo,
                                    OffsetDateTime dataEntrada) {
        this.id.setEstabelecimento(estabelecimento);
        this.id.setVeiculo(veiculo);
        this.dataEntrada = dataEntrada;
    }

    @PrePersist
    private void prePersist() {
        setDataEntrada(OffsetDateTime.now());
    }

    public EstabelecimentoEntity getEstabelecimento() {
        return id.getEstabelecimento();
    }

    public void setEstabelecimento(EstabelecimentoEntity estabelecimento) {
        id.setEstabelecimento(estabelecimento);
    }

    public VeiculoEntity getVeiculo() {
        return id.getVeiculo();
    }

    public void setVeiculo(VeiculoEntity veiculoEntity) {
        this.id.setVeiculo(veiculoEntity);
    }

}
