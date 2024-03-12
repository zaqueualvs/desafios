package com.alves.picpaysimplificado.adapters.out.persistence.h2.entities;

import com.alves.picpaysimplificado.domain.models.Usuario;
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
@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    @OneToOne
    private UsuarioEntity payer;
    @OneToOne
    private UsuarioEntity payee;
}
