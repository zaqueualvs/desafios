package com.alves.picpaysimplificado.adapters.out.persistence.h2.repositories;

import com.alves.picpaysimplificado.adapters.out.persistence.h2.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
