package com.alves.automovel.application.ports.out;

import com.alves.automovel.application.domain.models.Automovel;

public interface SaveAutomovelPort {

    Automovel save(Automovel automovel);
}
