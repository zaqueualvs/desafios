package com.alves.estacionamento.adapters.out.persistence.h2.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "historico_estacionamento")
public class HistoricoEstacionamentoEntity {
    @EmbeddedId
    private VagaEstacionamentoPKEntity id = new VagaEstacionamentoPKEntity();
    private OffsetDateTime dataEntrada;
    private OffsetDateTime dataSaida;

    public HistoricoEstacionamentoEntity(EstabelecimentoEntity estabelecimento,
                                         VeiculoEntity veiculo,
                                         OffsetDateTime dataEntrada) {
        this.id.setEstabelecimento(estabelecimento);
        this.id.setVeiculo(veiculo);
        this.dataEntrada = dataEntrada;
    }

    @PreUpdate
    private void preUpdate() {
        setDataSaida(OffsetDateTime.now());
    }

    public EstabelecimentoEntity getEstabelecimento() {
        return id.getEstabelecimento();
    }

    public void setEstabelecimento(EstabelecimentoEntity estabelecimento) {
        id.setEstabelecimento(estabelecimento);
    }

    public VeiculoEntity getVeiculoEntity() {
        return id.getVeiculo();
    }

    public void setVeiculoEntity(VeiculoEntity veiculoEntity) {
        this.id.setVeiculo(veiculoEntity);
    }
}
