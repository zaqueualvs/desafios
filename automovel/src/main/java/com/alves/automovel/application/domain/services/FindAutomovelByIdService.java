package com.alves.automovel.application.domain.services;

import com.alves.automovel.application.domain.exceptions.AutomovelNaoEncontradoException;
import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.in.FindAutomovelByIdUseCase;
import com.alves.automovel.application.ports.out.FindAutomovelByIdPort;
import com.alves.automovel.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAutomovelByIdService implements FindAutomovelByIdUseCase {
    private final FindAutomovelByIdPort findAutomovelByIdPort;

    @Override
    public Automovel find(Long id) {
        return findAutomovelByIdPort.find(id).orElseThrow(
                () -> new AutomovelNaoEncontradoException(id)
        );
    }
}
