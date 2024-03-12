package com.alves.picpaysimplificado.domain.models;

import java.math.BigDecimal;

public class Transaction {
    private Long id;
    private BigDecimal valor;
    private Usuario payer;
    private Usuario payee;

    public Transaction() {
    }

    public Transaction(Long id,
                       BigDecimal valor,
                       Usuario payer,
                       Usuario payee) {
        this.id = id;
        this.valor = valor;
        this.payer = payer;
        this.payee = payee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Usuario getPayer() {
        return payer;
    }

    public void setPayer(Usuario payer) {
        this.payer = payer;
    }

    public Usuario getPayee() {
        return payee;
    }

    public void setPayee(Usuario payee) {
        this.payee = payee;
    }
}
