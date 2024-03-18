package com.alves.automovel.application.domain.services;

import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.in.UpdateAutomovelUseCase;
import com.alves.automovel.application.ports.out.UpdateAutomovelPort;
import com.alves.automovel.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateAutomovelService implements UpdateAutomovelUseCase {
    private final UpdateAutomovelPort updateAutomovelPort;

    @Override
    public Automovel update(Automovel automovel) {
        return updateAutomovelPort.update(automovel);
    }
}
