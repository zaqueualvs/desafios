package com.alves.lanchonete.produto.adapters.in.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ProdutoResponse {
    private Long id;
    private String nome;
    private BigDecimal preco;
}
