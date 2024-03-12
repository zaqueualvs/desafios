package com.alves.picpaysimplificado.domain.services.usuario;

import com.alves.picpaysimplificado.application.ports.in.usuario.FindUsuarioByIdUseCase;
import com.alves.picpaysimplificado.application.ports.out.usuario.FindUsuarioByIdPort;
import com.alves.picpaysimplificado.common.customannotations.UseCase;
import com.alves.picpaysimplificado.domain.models.Usuario;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class FindUsuarioByIdService implements FindUsuarioByIdUseCase {
    private final FindUsuarioByIdPort findUsuarioByIdPort;

    @Override
    public Usuario find(Long id) {
        return findUsuarioByIdPort.find(id).orElseThrow(
                () -> new RuntimeException(
                        String.format("Usuario com id %d não encontrado", id)
                )
        );
    }
}
