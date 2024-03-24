package com.alves.restkafka.kafka.data;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PedidoData {
    private String codigo;
    private String nomeProduto;
    private BigDecimal valor;
}
