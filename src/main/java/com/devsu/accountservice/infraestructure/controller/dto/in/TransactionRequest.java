package com.devsu.accountservice.infraestructure.controller.dto.in;

import lombok.Builder;


@Builder
public record TransactionRequest(

         String transactionType,

         String amount,

         String balance,

         String accountId,

         String personId
) {
}
