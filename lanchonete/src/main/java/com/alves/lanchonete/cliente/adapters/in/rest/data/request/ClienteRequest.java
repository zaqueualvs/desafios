package com.alves.lanchonete.cliente.adapters.in.rest.data.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClienteRequest {

    @NotBlank
    private String nome;
    @Email
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank
    private String endereco;
}
