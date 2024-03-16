package com.alves.automovel.application.ports.in;

import com.alves.automovel.application.domain.models.Automovel;

public interface FindAutomovelByIdUseCase {

    Automovel find(Long id);
}
