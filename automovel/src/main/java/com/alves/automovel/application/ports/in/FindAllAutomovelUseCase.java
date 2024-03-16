package com.alves.automovel.application.ports.in;

import com.alves.automovel.application.domain.models.Automovel;

import java.util.List;

public interface FindAllAutomovelUseCase {

    List<Automovel> find();
}
