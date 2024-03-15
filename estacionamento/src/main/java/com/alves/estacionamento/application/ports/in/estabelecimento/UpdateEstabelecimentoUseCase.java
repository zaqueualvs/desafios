package com.alves.estacionamento.application.ports.in.estabelecimento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;

public interface UpdateEstabelecimentoUseCase {

    Estabelecimento update(Estabelecimento estabelecimento);
}
