package com.alves.estacionamento.application.ports.out.estabelecimento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;

import java.util.Optional;

public interface FindEstabelecimentoByIdPort {

    Optional<Estabelecimento> find(Long id);
}
