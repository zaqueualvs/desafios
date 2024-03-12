package com.alves.picpaysimplificado.adapters.out.persistence.h2.adapters.transaction;

import com.alves.picpaysimplificado.adapters.out.persistence.h2.entities.TransactionEntity;
import com.alves.picpaysimplificado.adapters.out.persistence.h2.mappers.TransactionPersistenceMapper;
import com.alves.picpaysimplificado.adapters.out.persistence.h2.repositories.TransactionRepository;
import com.alves.picpaysimplificado.application.ports.out.transaction.SaveTransactionPort;
import com.alves.picpaysimplificado.common.customannotations.PersistenceAdapter;
import com.alves.picpaysimplificado.domain.models.Transaction;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class SaveTransactionAdapter implements SaveTransactionPort {

    private final TransactionRepository transactionRepository;
    private final TransactionPersistenceMapper transactionPersistenceMapper;

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity transactionEntity = transactionPersistenceMapper.toEntity(transaction);
        transactionEntity = transactionRepository.save(transactionEntity);
        transaction = transactionPersistenceMapper.toDomain(transactionEntity);
        return transaction;
    }
}
