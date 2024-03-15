package com.alves.estacionamento.application.ports.in.estabelecimento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;


public interface FindEstabelecimentoByIdUseCase {

    Estabelecimento find(Long id);
}
