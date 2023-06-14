package com.example.baitapbuoi9.exception;

import org.springframework.http.HttpStatus;

public class UsernameAlreadyExistsException extends RuntimeException{
    private String message;
    private HttpStatus status;

    public UsernameAlreadyExistsException(String message) {
        this.message = message;
        this.status = HttpStatus.CONFLICT;
    }
}
