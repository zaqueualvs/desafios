package com.alves.automovel.application.domain.services;

import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.in.FindAllAutomovelUseCase;
import com.alves.automovel.application.ports.out.FindAllAutomovelPort;
import com.alves.automovel.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class FindAllAutomovelService implements FindAllAutomovelUseCase {

    private final FindAllAutomovelPort findAllAutomovelPort;

    @Override
    public List<Automovel> find(){
        return findAllAutomovelPort.find();
    }
}
