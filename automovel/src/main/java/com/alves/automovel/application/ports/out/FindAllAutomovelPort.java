package com.alves.automovel.application.ports.out;

import com.alves.automovel.application.domain.models.Automovel;

import java.util.List;

public interface FindAllAutomovelPort {

    List<Automovel> find();
}
