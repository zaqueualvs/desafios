package com.alves.automovel.adapters.out.persistence.h2.adapters;

import com.alves.automovel.application.domain.models.Automovel;

public interface UpdateAutomovelPort {

    Automovel update(Automovel automovel);
}
