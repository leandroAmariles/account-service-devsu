package com.devsu.accountservice.applications.mapper;


import com.devsu.accountservice.domain.model.Account;
import com.devsu.accountservice.domain.model.Transactions;
import com.devsu.accountservice.infraestructure.controller.dto.in.AccountRequest;
import com.devsu.accountservice.infraestructure.controller.dto.in.TransactionRequest;
import com.devsu.accountservice.infraestructure.controller.dto.out.AccountResponse;
import com.devsu.accountservice.infraestructure.controller.dto.out.TransactionsResponse;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;



@Mapper(builder = @Builder(disableBuilder = false))
public interface TransactionalMapper {

    Account accountToAccountModel(AccountRequest accountRequest);

    AccountResponse accountToAccountResponse(Account account);

    Transactions transactionDtoToTransactionModel(TransactionRequest transactionRequest);

    TransactionsResponse transactionDtoToTransactionsResponse(Transactions transactions);


}
