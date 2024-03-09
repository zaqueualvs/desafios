package com.alves.lanchonete.adapters.out.persistence.h2.entities;

import com.alves.lanchonete.domain.models.enuns.PedidoStatus;
import com.alves.lanchonete.adapters.out.persistence.h2.entities.ProdutoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Set;

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
    @ManyToMany
    @JoinTable(name = "item_pedido",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private Set<ProdutoEntity> produtos;
    private OffsetDateTime dataCriacao;
    private Integer status;
    @ManyToOne
    private ClienteEntity cliente;

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
