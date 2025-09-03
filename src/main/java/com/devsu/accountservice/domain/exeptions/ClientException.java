package com.devsu.accountservice.domain.exeptions;

public class ClientException extends RuntimeException {

    public ClientException(String message) {
        super(message);
    }
}
