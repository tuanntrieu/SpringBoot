package com.example.baitapbuoi5.exception;

import org.springframework.http.HttpStatus;

public class  ErrorResponse extends RuntimeException {
    private String message;

    private HttpStatus httpStatus;

    public ErrorResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}