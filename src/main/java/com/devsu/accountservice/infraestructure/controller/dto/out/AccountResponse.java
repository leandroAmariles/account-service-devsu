package com.devsu.accountservice.infraestructure.controller.dto.out;

public record AccountResponse (


         Long accountId,

         String accountNumber,

         String accountType,

         double initialBalance,

         String state
) {
}
