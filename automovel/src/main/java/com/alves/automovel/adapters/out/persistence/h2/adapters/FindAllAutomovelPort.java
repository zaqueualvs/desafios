package com.alves.automovel.adapters.out.persistence.h2.adapters;

import com.alves.automovel.application.domain.models.Automovel;

import java.util.List;

public interface FindAllAutomovelPort {

    List<Automovel> find();
}
