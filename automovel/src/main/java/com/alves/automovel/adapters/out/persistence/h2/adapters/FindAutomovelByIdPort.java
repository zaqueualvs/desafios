package com.alves.automovel.adapters.out.persistence.h2.adapters;

import com.alves.automovel.application.domain.models.Automovel;

import java.util.Optional;

public interface FindAutomovelByIdPort {

    Optional<Automovel> find(Long id);
}
