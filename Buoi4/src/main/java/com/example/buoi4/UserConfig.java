package com.example.buoi4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Value("user.username")
    String username;

    @Value("user.password")
    String password;



}
