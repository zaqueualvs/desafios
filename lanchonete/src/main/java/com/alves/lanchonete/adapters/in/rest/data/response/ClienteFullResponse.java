package com.alves.lanchonete.adapters.in.rest.data.response;

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
public class ClienteFullResponse {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private Set<PedidoResponse> pedidos = new HashSet<>();
}
