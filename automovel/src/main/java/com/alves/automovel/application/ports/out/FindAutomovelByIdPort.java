package com.alves.automovel.application.ports.out;

import com.alves.automovel.application.domain.models.Automovel;

import java.util.Optional;

public interface FindAutomovelByIdPort {

    Optional<Automovel> find(Long id);
}
