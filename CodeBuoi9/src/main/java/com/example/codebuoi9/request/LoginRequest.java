package com.example.codebuoi9.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private int id;

    private String username;

    private String password;

    private String token;

}
