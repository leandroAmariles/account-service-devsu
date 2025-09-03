package com.devsu.accountservice.applications.services;


import com.devsu.accountservice.applications.mapper.TransactionalMapper;
import com.devsu.accountservice.domain.exeptions.InsufficientBalanceException;
import com.devsu.accountservice.infraestructure.clients.querymanagementclient.IQueryDataClient;
import com.devsu.accountservice.infraestructure.controller.dto.in.AccountRequest;
import com.devsu.accountservice.infraestructure.controller.dto.in.TransactionRequest;
import com.devsu.accountservice.infraestructure.controller.dto.out.AccountResponse;
import com.devsu.accountservice.infraestructure.controller.dto.out.TransactionsResponse;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionalServiceImpl implements ITransactionalService {

    private final IQueryDataClient iQueryDataClient;

    private final TransactionalMapper transactionalMapper = Mappers.getMapper(TransactionalMapper.class);

    @Override
    public Mono<AccountResponse> createAccount(AccountRequest accountRequest) {
        return iQueryDataClient.createAccount(accountRequest)
                .map(transactionalMapper::accountToAccountResponse);
    }

    @Override
    public Mono<TransactionsResponse> createTransaction(TransactionRequest transactionRequest) {
        String accountId = transactionRequest.accountId();
        String amount = transactionRequest.amount();

       return iQueryDataClient.validateAmounts(accountId,amount)
               .flatMap(resp -> {
                   if (resp){
                       return iQueryDataClient.createTransaction(transactionRequest);
                   } else {
                          return Mono.error(new InsufficientBalanceException("Insufficient balance"));
                   }
               }).map(transactionalMapper::transactionDtoToTransactionsResponse);
    }


}
