package com.alves.automovel.application.ports.out;

import com.alves.automovel.application.domain.models.Automovel;

public interface UpdateAutomovelPort {

    Automovel update(Automovel automovel);
}
