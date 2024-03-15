package com.alves.estacionamento.application.domain.services.estabelecimento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.ports.in.estabelecimento.UpdateEstabelecimentoUseCase;
import com.alves.estacionamento.application.ports.out.estabelecimento.UpdateEstabelecimentoPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateEstabelecimentoService implements UpdateEstabelecimentoUseCase {

    private final UpdateEstabelecimentoPort updateEstabelecimentoPort;

    @Override
    public Estabelecimento update(Estabelecimento estabelecimento) {
        return updateEstabelecimentoPort.update(estabelecimento);
    }
}
