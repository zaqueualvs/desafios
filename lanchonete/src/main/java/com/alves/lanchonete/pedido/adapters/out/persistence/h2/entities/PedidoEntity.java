package com.alves.lanchonete.pedido.adapters.out.persistence.h2.entities;

import com.alves.lanchonete.cliente.adapters.out.persistence.h2.entities.ClienteEntity;
import com.alves.lanchonete.pedido.domain.models.enuns.PedidoStatus;
import com.alves.lanchonete.produto.adapters.out.persistence.h2.entities.ProdutoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "pedido")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private ClienteEntity cliente;
    @OneToOne
    private ProdutoEntity produto;
    private OffsetDateTime dataCriacao;
    private Integer status;

    @PrePersist
    private void prePersistence() {
        dataCriacao = OffsetDateTime.now();
    }

    public PedidoStatus getStatus() {
        return PedidoStatus.toEnum(status);
    }

    public void setStatus(PedidoStatus pedidoStatus) {
        this.status = pedidoStatus.getCod();
    }
}
