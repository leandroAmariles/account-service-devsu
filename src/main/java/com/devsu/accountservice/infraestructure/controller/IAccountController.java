package com.devsu.accountservice.infraestructure.controller;

import com.devsu.accountservice.infraestructure.controller.dto.in.AccountRequest;
import com.devsu.accountservice.infraestructure.controller.dto.in.TransactionRequest;
import com.devsu.accountservice.infraestructure.controller.dto.out.AccountResponse;
import com.devsu.accountservice.infraestructure.controller.dto.out.TransactionsResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface IAccountController {

    ResponseEntity<Mono<AccountResponse>> createAccount(AccountRequest accountRequest);

    ResponseEntity<Mono<TransactionsResponse>> createTransaction(TransactionRequest transactionRequest);

}
