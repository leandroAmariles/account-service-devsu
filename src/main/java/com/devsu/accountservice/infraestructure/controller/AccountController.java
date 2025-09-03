package com.devsu.accountservice.infraestructure.controller;


import com.devsu.accountservice.applications.services.ITransactionalService;
import com.devsu.accountservice.infraestructure.controller.dto.in.AccountRequest;
import com.devsu.accountservice.infraestructure.controller.dto.in.TransactionRequest;
import com.devsu.accountservice.infraestructure.controller.dto.out.AccountResponse;
import com.devsu.accountservice.infraestructure.controller.dto.out.TransactionsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/devsu/test/v1/")
@RequiredArgsConstructor
public class AccountController implements IAccountController {

    private final ITransactionalService transactionalService;


    @Override
    @PostMapping("/cuentas")
    public ResponseEntity<Mono<AccountResponse>> createAccount(@RequestBody AccountRequest accountRequest) {
        return new ResponseEntity<>(transactionalService.createAccount(accountRequest), HttpStatus.OK);
    }

    @Override
    @PostMapping("/movimientos")
    public ResponseEntity<Mono<TransactionsResponse>> createTransaction(@RequestBody TransactionRequest transactionRequest) {
        return new ResponseEntity<>(transactionalService.createTransaction(transactionRequest), HttpStatus.OK);
    }
}
