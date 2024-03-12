package com.alves.picpaysimplificado.domain.models;

import com.alves.picpaysimplificado.domain.models.enuns.TipoUsuario;

import java.math.BigDecimal;

public class Usuario {
    private Long id;
    private String nome;
    private String cpf;
    private String senha;
    private String email;
    private BigDecimal saldo;
    private TipoUsuario tipoUsuario;

    public Usuario() {
    }

    public Usuario(Long id,
                   String nome,
                   String cpf,
                   String senha,
                   String email,
                   BigDecimal saldo,
                   TipoUsuario tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.saldo = saldo;
        this.tipoUsuario = tipoUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
