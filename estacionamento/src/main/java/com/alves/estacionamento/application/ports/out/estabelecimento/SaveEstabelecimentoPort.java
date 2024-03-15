package com.alves.estacionamento.application.ports.out.estabelecimento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;

public interface SaveEstabelecimentoPort {

    Estabelecimento save(Estabelecimento estabelecimento);
}
