package com.alves.estacionamento.application.domain.services.estabelecimento;

import com.alves.estacionamento.application.domain.exceptions.EstabelecimentoNaoEncontradoException;
import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.ports.in.estabelecimento.FindEstabelecimentoByIdUseCase;
import com.alves.estacionamento.application.ports.out.estabelecimento.FindEstabelecimentoByIdPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindEstabelecimentoByIdService implements FindEstabelecimentoByIdUseCase {

    private final FindEstabelecimentoByIdPort findEstabelecimentoByIdPort;

    @Override
    public Estabelecimento find(Long id) {
        return findEstabelecimentoByIdPort.find(id)
                .orElseThrow(
                        () -> new EstabelecimentoNaoEncontradoException(id)
                );
    }
}
