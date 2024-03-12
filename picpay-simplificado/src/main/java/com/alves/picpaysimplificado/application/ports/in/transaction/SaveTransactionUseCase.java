package com.alves.picpaysimplificado.application.ports.in.transaction;

import com.alves.picpaysimplificado.domain.models.Transaction;

public interface SaveTransactionUseCase {

    Transaction save(Transaction transaction);
}
