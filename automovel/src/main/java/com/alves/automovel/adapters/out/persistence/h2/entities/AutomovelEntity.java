package com.alves.automovel.adapters.out.persistence.h2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Generated
@Entity
@Table(name = "automovel")
public class AutomovelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private String ano;
}