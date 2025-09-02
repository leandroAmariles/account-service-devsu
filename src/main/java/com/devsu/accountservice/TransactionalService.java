package com.devsu.accountservice;


import com.devsu.accountservice.applications.services.ITransactionalService;
import com.devsu.accountservice.infraestructure.controller.dto.in.AccountRequest;
import com.devsu.accountservice.infraestructure.controller.dto.out.AccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionalService implements ITransactionalService {

    @Override
    public AccountResponse createAccount(AccountRequest accountRequest) {
        return null;
    }
}
