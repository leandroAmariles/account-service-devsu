package com.devsu.accountservice.infraestructure.clients.querymanagementclient;

import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.domain.model.Transactions;
import com.devsu.accountservice.infraestructure.controller.dto.in.AccountRequest;
import com.devsu.accountservice.infraestructure.controller.dto.in.TransactionRequest;
import reactor.core.publisher.Mono;

public interface IQueryDataClient {

    Mono<Boolean> validateAmounts(String accountId, String amount);

    Mono<Account> createAccount(AccountRequest account);

    Mono<Transactions> createTransaction(TransactionRequest transaction);
}
