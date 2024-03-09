package com.alves.lanchonete.adapters.in.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClienteResponse {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
}
