package com.alves.estacionamento.application.ports.out.estabelecimento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;

public interface DeleteEstabelecimentoPort {

    void delete(Estabelecimento estabelecimento);
}
