package com.alves.estacionamento.adapters.in.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EstabelecimentoReponse {
    private Long id;
    private String cnpj;
    private String endereco;
    private String telefone;
    private Integer totalVagasMotos;
    private Integer totalVagasCarros;
}
