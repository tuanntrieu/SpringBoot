package com.example.baitapbuoi9.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotNull(message = "Fullname is not null")
    private String fullname;

    private String address;

    private String email;


    private Date birthday;

    @NotEmpty(message = "username is not empty")
    private String username;

    @NotEmpty(message = "password is not empty")
    private String password;
}
