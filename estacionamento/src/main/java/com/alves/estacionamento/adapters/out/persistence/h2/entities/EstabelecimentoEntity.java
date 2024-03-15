package com.alves.estacionamento.adapters.out.persistence.h2.entities;

import com.alves.estacionamento.application.domain.models.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.annotation.Documented;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "estabelecimento")
public class EstabelecimentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String cnpj;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private Integer totalVagasMotos;
    @Column(nullable = false)
    private Integer totalVagasCarros;
    @OneToMany(mappedBy = "id.estabelecimento")
    private Set<VagaEstacionamentoEntity> vagasUsada = new HashSet<>();
}
