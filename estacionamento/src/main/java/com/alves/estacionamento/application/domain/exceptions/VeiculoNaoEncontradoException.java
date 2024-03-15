package com.alves.estacionamento.application.domain.exceptions;

public class VeiculoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public VeiculoNaoEncontradoException(Long id) {
        super(String.format("Não existe um cadastro de veiculo com id %d", id));
    }
}
