package com.alves.automovel.application.domain.exceptions;

public class EntidadeNaoEncontradaException extends RuntimeException{

    public EntidadeNaoEncontradaException(String message) {
        super(message);
    }
}
