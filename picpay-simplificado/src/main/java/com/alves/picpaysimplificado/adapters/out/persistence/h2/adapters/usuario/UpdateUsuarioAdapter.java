package com.alves.picpaysimplificado.adapters.out.persistence.h2.adapters.usuario;

import com.alves.picpaysimplificado.adapters.out.persistence.h2.entities.UsuarioEntity;
import com.alves.picpaysimplificado.adapters.out.persistence.h2.mappers.UsuarioPersistenceMapper;
import com.alves.picpaysimplificado.adapters.out.persistence.h2.repositories.UsuarioRepository;
import com.alves.picpaysimplificado.application.ports.out.usuario.UpdateUsuarioPort;
import com.alves.picpaysimplificado.common.customannotations.PersistenceAdapter;
import com.alves.picpaysimplificado.domain.models.Usuario;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class UpdateUsuarioAdapter implements UpdateUsuarioPort {

    private final UsuarioPersistenceMapper usuarioPersistenceMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public void update(Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioPersistenceMapper.toEntity(usuario);
        usuarioRepository.save(usuarioEntity);
    }
}
