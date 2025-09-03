package com.devsu.accountservice.infraestructure.clients.querymanagementclient.client;

import com.devsu.accountservice.domain.exeptions.ClientException;
import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.domain.model.Transactions;
import com.devsu.accountservice.infraestructure.clients.querymanagementclient.IQueryDataClient;

import com.devsu.accountservice.infraestructure.controller.dto.in.AccountRequest;
import com.devsu.accountservice.infraestructure.controller.dto.in.TransactionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QueryDataClientImpl implements IQueryDataClient {

    @Value("${client.query-data-service.url}")
    private String baseUrl;

    @Value("${client.query-data-service.path-creation-account}")
    private String createAccountPath;

    @Value("${client.query-data-service.path-update-account}")
    private String updateAccountPath;

    @Value("${client.query-data-service.path-creation-transaction}")
    private String createTransactionPath;

    @Value("${client.query-data-service.path-update-transaction}")
    private String updateTransactionPath;

    @Value("${client.query-data-service.path-validate-balance}")
    private String validateBalancePath;

    private final WebClient webClient;

    @Override
    public Mono<Boolean> validateAmounts(String accountId, String amount) {
        return webClient.get().uri(baseUrl.concat(validateBalancePath.concat(accountId).concat("/").concat(amount)))
                .headers(httpHeaders -> httpHeaders.setContentType(MediaType.APPLICATION_JSON))
                .retrieve().bodyToMono(Boolean.class)
                .onErrorResume(e -> Mono.error(new ClientException("Error validating balance with Query Data Management Service")));

    }
    @Override
    public Mono<Account> createAccount(AccountRequest account) {
        return webClient.post()
                .uri(baseUrl.concat(createAccountPath))
                .headers(httpHeaders -> httpHeaders.setContentType(MediaType.APPLICATION_JSON))
                .bodyValue(account)
                .retrieve()
                .onStatus(
                        HttpStatusCode::isError,
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(new ClientException("Error creando cuenta: " + errorBody)))
                )
                .bodyToMono(Account.class);
    }

    @Override
    public Mono<Transactions> createTransaction(TransactionRequest transaction) {
        return webClient.post().uri(baseUrl.concat(createTransactionPath))
                .headers(httpHeaders -> httpHeaders.setContentType(MediaType.APPLICATION_JSON))
                .bodyValue(transaction)
                .retrieve().onStatus(
                        HttpStatusCode::isError,
                        clientResponse -> clientResponse.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(new ClientException("Error creando transaction: " + errorBody)))
                )
                .bodyToMono(Transactions.class);
    }
}
