package com.alves.planetas.infraestructure.delivery.rest;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PlanetaRest implements Serializable {
    private Long id;

    @NonNull
    private String nome;
    @NonNull
    private String clima;
    @NonNull
    private String terreno;
}
