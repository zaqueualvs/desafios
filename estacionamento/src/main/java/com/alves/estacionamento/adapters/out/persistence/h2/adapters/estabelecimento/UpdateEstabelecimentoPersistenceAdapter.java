package com.alves.estacionamento.adapters.out.persistence.h2.adapters.estabelecimento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.ports.out.estabelecimento.SaveEstabelecimentoPort;
import com.alves.estacionamento.application.ports.out.estabelecimento.UpdateEstabelecimentoPort;
import com.alves.estacionamento.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class UpdateEstabelecimentoPersistenceAdapter implements UpdateEstabelecimentoPort {
    private final SaveEstabelecimentoPort saveEstabelecimentoPort;

    @Override
    public Estabelecimento update(Estabelecimento estabelecimento) {
        return saveEstabelecimentoPort.save(estabelecimento);
    }
}
