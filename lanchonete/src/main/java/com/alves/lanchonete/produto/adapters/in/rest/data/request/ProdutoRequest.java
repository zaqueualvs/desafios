package com.alves.lanchonete.produto.adapters.in.rest.data.request;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProdutoRequest {
    private String nome;
    private BigDecimal preco;
}
