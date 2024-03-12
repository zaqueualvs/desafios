package com.alves.picpaysimplificado.adapters.out.persistence.h2.mappers;

import com.alves.picpaysimplificado.adapters.out.persistence.h2.entities.TransactionEntity;
import com.alves.picpaysimplificado.adapters.out.persistence.h2.entities.UsuarioEntity;
import com.alves.picpaysimplificado.domain.models.Transaction;
import com.alves.picpaysimplificado.domain.models.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionPersistenceMapper {

    TransactionEntity toEntity(Transaction transaction);

    Transaction toDomain(TransactionEntity transactionEntity);
}
