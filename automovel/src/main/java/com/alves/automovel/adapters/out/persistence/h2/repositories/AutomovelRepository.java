package com.alves.automovel.adapters.out.persistence.h2.repositories;

import com.alves.automovel.adapters.out.persistence.h2.entities.AutomovelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomovelRepository extends JpaRepository<AutomovelEntity, Long> {
}
