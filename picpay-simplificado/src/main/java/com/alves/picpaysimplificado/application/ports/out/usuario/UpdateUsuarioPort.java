package com.alves.picpaysimplificado.application.ports.out.usuario;

import com.alves.picpaysimplificado.domain.models.Usuario;

public interface UpdateUsuarioPort {

    void update(Usuario usuario);
}
