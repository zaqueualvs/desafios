package com.alves.microsservicekafka.data;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PedidoData {
    private String codigo;
    private String nomeProduto;
    private BigDecimal valor;
}
