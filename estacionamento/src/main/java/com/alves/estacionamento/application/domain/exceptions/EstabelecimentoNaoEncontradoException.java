package com.alves.estacionamento.application.domain.exceptions;

public class EstabelecimentoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public EstabelecimentoNaoEncontradoException(Long id) {
        super(String.format("Não existe um cadastro de estabelecimento com id %d", id));
    }
}
