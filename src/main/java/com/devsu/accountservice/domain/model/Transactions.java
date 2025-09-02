package com.devsu.accountservice.domain.model;


import java.time.LocalDateTime;


public class Transactions {

    private Long transactionId;

    private LocalDateTime transactionDate;

    private String transactionType;

    private String amount;

    private String balance;

    private Account account;

}
