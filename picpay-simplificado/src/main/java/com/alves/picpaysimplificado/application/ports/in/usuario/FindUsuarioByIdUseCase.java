package com.alves.picpaysimplificado.application.ports.in.usuario;

import com.alves.picpaysimplificado.domain.models.Usuario;

import java.util.Optional;

public interface FindUsuarioByIdUseCase {

    Usuario find(Long id);
}
