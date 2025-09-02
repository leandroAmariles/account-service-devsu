package com.devsu.accountservice.domain.model;


import java.util.List;


public class Account {

    private Long accountId;

    private String accountNumber;

    private String accountType;

    private double initialBalance;

    private String state;

    private List<Transactions> transactions;

}
