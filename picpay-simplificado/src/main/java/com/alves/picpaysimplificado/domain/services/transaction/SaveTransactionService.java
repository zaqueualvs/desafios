package com.alves.picpaysimplificado.domain.services.transaction;

import com.alves.picpaysimplificado.application.ports.in.transaction.SaveTransactionUseCase;
import com.alves.picpaysimplificado.application.ports.in.usuario.FindUsuarioByIdUseCase;
import com.alves.picpaysimplificado.application.ports.out.transaction.SaveTransactionPort;
import com.alves.picpaysimplificado.application.ports.out.usuario.UpdateUsuarioPort;
import com.alves.picpaysimplificado.common.customannotations.UseCase;
import com.alves.picpaysimplificado.domain.models.Transaction;
import com.alves.picpaysimplificado.domain.models.Usuario;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@UseCase
@RequiredArgsConstructor
public class SaveTransactionService implements SaveTransactionUseCase {

    private final FindUsuarioByIdUseCase findUsuarioByIdUseCase;
    private final SaveTransactionPort saveTransactionPort;
    private final ValidateTransactionService validateTransactionService;
    private final UpdateUsuarioPort updateUsuarioPort;
    private final AutorizationTransactionService autorizationTransactionService;

    @Override
    public Transaction save(Transaction transaction) {

        Usuario payer = findUsuarioByIdUseCase.find(transaction.getPayer().getId());
        Usuario payee = findUsuarioByIdUseCase.find(transaction.getPayee().getId());
        BigDecimal value = transaction.getValor();

        validateTransactionService.valid(payer, value);

        Boolean isAutorized = autorizationTransactionService.autorizeTransaction(payee, value);

        if (!isAutorized) {
            throw new RuntimeException("Transação não autorizada");
        }

        payer.setSaldo(payer.getSaldo().subtract(value));
        payee.setSaldo(payee.getSaldo().add(value));

        transaction.setPayee(payee);
        transaction.setPayer(payer);

        updateUsuarioPort.update(payee);
        updateUsuarioPort.update(payer);

        return saveTransactionPort.save(transaction);
    }
}
