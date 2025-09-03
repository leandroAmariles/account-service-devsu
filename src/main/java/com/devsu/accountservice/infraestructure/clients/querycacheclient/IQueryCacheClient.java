package com.devsu.accountservice.infraestructure.clients.querycacheclient;

import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.infraestructure.controller.dto.in.AccountRequest;
import com.devsu.accountservice.infraestructure.controller.dto.out.AccountResponse;

public interface IQueryCacheClient {

    Account getAccount(String id);
}
