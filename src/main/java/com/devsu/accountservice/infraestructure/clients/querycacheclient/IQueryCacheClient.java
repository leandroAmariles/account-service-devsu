package com.devsu.accountservice.infraestructure.clients.querycacheclient;

import com.devsu.accountservice.domain.model.Account;

public interface IQueryCacheClient {

    Account getAccount(String id);
}
