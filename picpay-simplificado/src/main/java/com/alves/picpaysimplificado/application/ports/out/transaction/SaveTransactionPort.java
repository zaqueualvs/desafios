package com.alves.picpaysimplificado.application.ports.out.transaction;

import com.alves.picpaysimplificado.domain.models.Transaction;

public interface SaveTransactionPort {
    Transaction save(Transaction transaction);
}
