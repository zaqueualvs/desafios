package com.alves.estacionamento.adapters.in.rest.data.response;

import com.alves.estacionamento.application.domain.models.VagaEstacionamento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EstabelecimentoFullReponse {
    private Long id;
    private String cnpj;
    private String endereco;
    private String telefone;
    private Integer totalVagasMotos;
    private Integer totalVagasCarros;
    private Set<VagaEstacionamentoResponse> vagasUsada = new HashSet<>();
}
