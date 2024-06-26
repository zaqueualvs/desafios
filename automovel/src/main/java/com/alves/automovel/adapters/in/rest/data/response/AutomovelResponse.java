package com.alves.automovel.adapters.in.rest.data.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AutomovelResponse extends RepresentationModel<AutomovelResponse> {
    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private String ano;
}