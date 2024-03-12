package com.alves.picpaysimplificado.adapters.in.rest.data.request;

import com.alves.picpaysimplificado.domain.models.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TransactionRequest {
    @NotNull
    private BigDecimal valor;
    @NotNull
    private Long payer;
    @NotNull
    private Long payee;
}
