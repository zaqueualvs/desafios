package com.alves.estacionamento.application.domain.services.estabelecimento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.ports.in.estabelecimento.SaveEstabelecimentoUseCase;
import com.alves.estacionamento.application.ports.out.estabelecimento.SaveEstabelecimentoPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SaveEstabelecimentoService implements SaveEstabelecimentoUseCase {

    private final SaveEstabelecimentoPort saveEstabelecimentoPort;

    @Override
    public Estabelecimento save(Estabelecimento estabelecimento) {
        return saveEstabelecimentoPort.save(estabelecimento);
    }
}
