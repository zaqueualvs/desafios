package com.alves.picpaysimplificado.adapters.in.rest.controllers;

import com.alves.picpaysimplificado.adapters.in.rest.data.request.TransactionRequest;
import com.alves.picpaysimplificado.adapters.in.rest.mappers.TransactionRestMapper;
import com.alves.picpaysimplificado.application.ports.in.transaction.SaveTransactionUseCase;
import com.alves.picpaysimplificado.domain.models.Transaction;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionRestMapper transactionRestMapper;
    private final SaveTransactionUseCase saveTransactionUseCase;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid TransactionRequest transactionRequest) {
        Transaction transaction = transactionRestMapper.toDomain(transactionRequest);
        saveTransactionUseCase.save(transaction);
        return ResponseEntity.ok().build();
    }
}
