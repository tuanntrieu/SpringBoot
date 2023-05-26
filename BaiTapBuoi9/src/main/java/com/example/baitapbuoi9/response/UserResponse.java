package com.example.baitapbuoi9.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private int id;

    private String fullName;

    private String address;

    private String email;

    private String accessToken;

    private Collection<? extends GrantedAuthority> authorities;
}
