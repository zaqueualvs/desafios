package com.alves.lanchonete.domain.models;

import com.alves.lanchonete.domain.models.enuns.PedidoStatus;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

public class Pedido {
    private Long id;
    private Set<Produto> produtos = new HashSet<>();
    private OffsetDateTime dataCriacao;
    private PedidoStatus status;
    private Cliente cliente;

    public Pedido() {
    }

    public Pedido(Long id,
                  OffsetDateTime dataCriacao,
                  PedidoStatus status,
                  Cliente cliente) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.status = status;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(OffsetDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public PedidoStatus getStatus() {
        return status;
    }

    public void setStatus(PedidoStatus status) {
        this.status = status;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }
}
