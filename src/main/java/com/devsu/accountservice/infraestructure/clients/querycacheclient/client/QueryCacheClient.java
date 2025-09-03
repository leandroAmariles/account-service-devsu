package com.devsu.accountservice.infraestructure.clients.querycacheclient.client;

import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.infraestructure.clients.querycacheclient.IQueryCacheClient;
import com.devsu.accountservice.infraestructure.controller.dto.in.AccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class QueryCacheClient implements IQueryCacheClient {



    private final WebClient webClient;


    @Override
    public Account getAccount(String id) {
        return null;
    }
}
