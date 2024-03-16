package com.alves.automovel.adapters.out.persistence.h2.adapters;

import com.alves.automovel.adapters.out.persistence.h2.repositories.AutomovelRepository;
import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.out.DeleteAutomovelPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteAutomovelPersistenceAdapter implements DeleteAutomovelPort {

    private final AutomovelRepository automovelRepository;

    public void delete(Automovel automovel){

    }
}
