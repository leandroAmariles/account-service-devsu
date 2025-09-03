package com.devsu.accountservice.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {

    private Long transactionId;

    private LocalDateTime transactionDate;

    private String transactionType;

    private String amount;

    private String balance;

    private String accountId;

}
