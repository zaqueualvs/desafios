package com.alves.estacionamento.application.domain.services.estabelecimento;

import com.alves.estacionamento.application.domain.models.Estabelecimento;
import com.alves.estacionamento.application.ports.in.estabelecimento.DeleteEstabelecimentoByIdUseCase;
import com.alves.estacionamento.application.ports.in.estabelecimento.FindEstabelecimentoByIdUseCase;
import com.alves.estacionamento.application.ports.out.estabelecimento.DeleteEstabelecimentoPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DeleteEstabelecimentoByIdService implements DeleteEstabelecimentoByIdUseCase {

    private final FindEstabelecimentoByIdUseCase findEstabelecimentoByIdUseCase;

    private final DeleteEstabelecimentoPort deleteEstabelecimentoPort;

    @Override
    public void delete(Long id) {
        Estabelecimento estabelecimento = findEstabelecimentoByIdUseCase.find(id);
        deleteEstabelecimentoPort.delete(estabelecimento);
    }


}
