package com.alves.automovel.application.domain.services;

import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.in.DeleteAutomovelByIdUseCase;
import com.alves.automovel.application.ports.in.FindAutomovelByIdUseCase;
import com.alves.automovel.application.ports.out.DeleteAutomovelPort;
import com.alves.automovel.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DeleteAutomovelByIdService implements DeleteAutomovelByIdUseCase {

    private final FindAutomovelByIdUseCase findAutomovelByIdUseCase;
    private final DeleteAutomovelPort deleteAutomovelPort;

    @Override
    public void delete(Long id) {
        Automovel automovel = findAutomovelByIdUseCase.find(id);
        deleteAutomovelPort.delete(automovel);
    }
}
