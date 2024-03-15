package com.alves.estacionamento.application.domain.services.veiculo;

import com.alves.estacionamento.application.domain.models.Veiculo;
import com.alves.estacionamento.application.ports.in.veiculo.DeleteVeiculoByIdUseCase;
import com.alves.estacionamento.application.ports.in.veiculo.FindVeiculoByIdUseCase;
import com.alves.estacionamento.application.ports.out.veiculo.DeleteVeiculoPort;
import com.alves.estacionamento.common.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DeleteVeiculoByIdService implements DeleteVeiculoByIdUseCase {

    private final DeleteVeiculoPort deleteVeiculoPort;
    private final FindVeiculoByIdUseCase findVeiculoByIdUseCase;


    @Override
    public void delete(Long id) {
        Veiculo veiculo = findVeiculoByIdUseCase.find(id);
        deleteVeiculoPort.delete(veiculo);
    }
}