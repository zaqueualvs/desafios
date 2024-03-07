package com.alves.lanchonete.pedido.domain.models;

import com.alves.lanchonete.cliente.domain.models.Cliente;
import com.alves.lanchonete.pedido.domain.models.enuns.PedidoStatus;
import com.alves.lanchonete.produto.domain.models.Produto;

import java.time.OffsetDateTime;

public class Pedido {
    private Long id;
    private Cliente cliente;
    private Produto produto;
    private OffsetDateTime dataCriacao;
    private PedidoStatus status;

    public Pedido() {
    }

    public Pedido(Long id,
                  Cliente cliente,
                  Produto produto,
                  OffsetDateTime dataCriacao,
                  PedidoStatus status) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.dataCriacao = dataCriacao;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
}
