package com.alves.estacionamento.application.domain.services.estabelecimento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.ports.in.estabelecimento.FindAllEstabelecimentoUseCase;
import com.alves.estacionamento.application.ports.out.estabelecimento.FindAllEstabelecimentoPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllEstabelecimentoService implements FindAllEstabelecimentoUseCase {

    private final FindAllEstabelecimentoPort findAllEstabelecimentoPort;

    @Override
    public List<Estabelecimento> find() {
        return findAllEstabelecimentoPort.find();
    }
}
