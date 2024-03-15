package com.alves.estacionamento.application.ports.in.vagaestacionamento;

import com.alves.estacionamento.application.domain.models.VagaEstacionamento;

public interface SaveVagaEstacionamentoUseCase {

    VagaEstacionamento save(VagaEstacionamento vagaEstacionamento);
}
