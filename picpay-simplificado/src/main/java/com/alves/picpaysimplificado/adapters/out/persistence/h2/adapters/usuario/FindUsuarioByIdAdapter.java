package com.alves.picpaysimplificado.adapters.out.persistence.h2.adapters.usuario;

import com.alves.picpaysimplificado.adapters.out.persistence.h2.entities.UsuarioEntity;
import com.alves.picpaysimplificado.adapters.out.persistence.h2.mappers.UsuarioPersistenceMapper;
import com.alves.picpaysimplificado.adapters.out.persistence.h2.repositories.UsuarioRepository;
import com.alves.picpaysimplificado.application.ports.out.usuario.FindUsuarioByIdPort;
import com.alves.picpaysimplificado.common.customannotations.PersistenceAdapter;
import com.alves.picpaysimplificado.domain.models.Usuario;
import lombok.AllArgsConstructor;

import java.util.Optional;


@AllArgsConstructor
@PersistenceAdapter
public class FindUsuarioByIdAdapter implements FindUsuarioByIdPort {

    private final UsuarioPersistenceMapper usuarioPersistenceMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> find(Long id) {
        Optional<UsuarioEntity> usuarioEntityO = usuarioRepository.findById(id);
        if (usuarioEntityO.isEmpty()) {
            Optional.empty();
        }
        Usuario usuario = usuarioPersistenceMapper.toDomain(usuarioEntityO.get());
        return Optional.of(usuario);
    }
}
