package com.alves.picpaysimplificado.application.ports.out.usuario;

import com.alves.picpaysimplificado.domain.models.Usuario;

import java.util.Optional;

public interface FindUsuarioByIdPort {

    Optional<Usuario> find(Long id);
}
