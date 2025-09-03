package com.devsu.accountservice.infraestructure.controller.dto.out;

import com.devsu.accountservice.domain.model.Account;

import java.time.LocalDateTime;

public record TransactionsResponse(

         Long transactionId,

         LocalDateTime transactionDate,

         String transactionType,

         String amount,

         String balance,

         String  accountId
) {
}
