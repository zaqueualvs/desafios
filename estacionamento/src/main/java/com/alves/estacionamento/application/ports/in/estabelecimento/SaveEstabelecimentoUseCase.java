package com.alves.estacionamento.application.ports.in.estabelecimento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;

public interface SaveEstabelecimentoUseCase {

    Estabelecimento save(Estabelecimento estabelecimento);
}
