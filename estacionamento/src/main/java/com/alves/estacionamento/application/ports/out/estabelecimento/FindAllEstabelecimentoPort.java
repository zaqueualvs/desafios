package com.alves.estacionamento.application.ports.out.estabelecimento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;

import java.util.List;

public interface FindAllEstabelecimentoPort {

    List<Estabelecimento> find();
}
