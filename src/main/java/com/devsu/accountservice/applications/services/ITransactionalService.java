package com.devsu.accountservice.applications.services;

import com.devsu.accountservice.infraestructure.controller.dto.in.AccountRequest;
import com.devsu.accountservice.infraestructure.controller.dto.out.AccountResponse;

public interface ITransactionalService {

    AccountResponse createAccount(AccountRequest accountRequest);
}
