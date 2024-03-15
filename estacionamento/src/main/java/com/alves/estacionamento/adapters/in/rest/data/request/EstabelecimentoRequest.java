package com.alves.estacionamento.adapters.in.rest.data.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EstabelecimentoRequest {
    @NotBlank
    private String cnpj;
    @NotBlank
    private String endereco;
    @NotBlank
    private String telefone;
    @PositiveOrZero
    private Integer totalVagasMotos;
    @PositiveOrZero
    private Integer totalVagasCarros;
}
