package com.devsu.accountservice.infraestructure.controller;


import com.devsu.accountservice.infraestructure.controller.dto.in.AccountRequest;
import com.devsu.accountservice.infraestructure.controller.dto.out.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class AccountController implements IAccountController {


    @Override
    public ResponseEntity<Mono<AccountResponse>> createAccount(Mono<AccountRequest> accountRequest) {
        return null;
    }
}
