package com.alves.automovel.application.domain.services;

import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.in.SaveAutomovelUseCase;
import com.alves.automovel.application.ports.out.SaveAutomovelPort;
import com.alves.automovel.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SaveAutomovelService implements SaveAutomovelUseCase {

    private final SaveAutomovelPort saveAutomovelPort;

    @Override
    public Automovel save(Automovel automovel) {
        return saveAutomovelPort.save(automovel);
    }
}
