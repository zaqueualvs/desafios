package com.alves.automovel.application.domain.exceptions;

public class AutomovelNaoEncontradoException extends EntidadeNaoEncontradaException {

    public AutomovelNaoEncontradoException(String message) {
        super(message);
    }

    public AutomovelNaoEncontradoException(Long id) {
        super(String.format("Não existe um cadastro de automovel com id %d", id));
    }
}
