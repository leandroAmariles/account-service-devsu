package com.devsu.accountservice.infraestructure.controller.dto.in;

import java.math.BigDecimal;

public record AccountRequest(

         String accountNumber,

         String accountType,

         BigDecimal initialBalance,

         Long personId
) {
}
