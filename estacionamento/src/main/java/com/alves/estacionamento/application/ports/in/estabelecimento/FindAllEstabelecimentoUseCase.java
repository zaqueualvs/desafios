package com.alves.estacionamento.application.ports.in.estabelecimento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;

import java.util.List;

public interface FindAllEstabelecimentoUseCase {

    List<Estabelecimento> find();
}
