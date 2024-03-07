package com.alves.lanchonete.cliente.adapters.out.persistence.h2.repositories;

import com.alves.lanchonete.cliente.adapters.out.persistence.h2.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRespository extends JpaRepository<ClienteEntity, Long> {

    Boolean existsByEmail(String email);

    Boolean existsByTelefone(String telefone);
}
