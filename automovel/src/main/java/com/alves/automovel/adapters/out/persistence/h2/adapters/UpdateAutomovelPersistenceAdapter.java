package com.alves.automovel.adapters.out.persistence.h2.adapters;

import com.alves.automovel.application.domain.models.Automovel;
import com.alves.automovel.application.ports.out.SaveAutomovelPort;
import com.alves.automovel.application.ports.out.UpdateAutomovelPort;
import com.alves.automovel.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UpdateAutomovelPersistenceAdapter implements UpdateAutomovelPort {

    private final SaveAutomovelPort saveAutomovelPort;

    @Override
    public Automovel update(Automovel automovel) {
        return saveAutomovelPort.save(automovel);
    }
}
