package com.devsu.accountservice.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long accountId;

    private String accountNumber;

    private String accountType;

    private double initialBalance;

    private String state;


}
