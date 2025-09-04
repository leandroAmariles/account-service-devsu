package com.devsu.accountservice.applications.services;

import com.devsu.accountservice.infraestructure.controller.dto.in.AccountRequest;
import com.devsu.accountservice.infraestructure.controller.dto.in.TransactionRequest;
import com.devsu.accountservice.infraestructure.controller.dto.out.AccountResponse;
import com.devsu.accountservice.infraestructure.controller.dto.out.TransactionsResponse;
import reactor.core.publisher.Mono;

public interface ITransactionalService {

    Mono<AccountResponse> createAccount(AccountRequest accountRequest);

    Mono<TransactionsResponse> createTransaction(TransactionRequest transactionRequest);

    Mono<AccountResponse> getAccountById(String id);
}
