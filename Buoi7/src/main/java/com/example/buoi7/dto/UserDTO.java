package com.example.buoi7.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotBlank(message = "Name is not null")
    private String name;

    @NotEmpty(message = "Address is not empty")
    private String address;
//@NotBlank: NotNull+ Null Empty
    MultipartFile multipartFile;
    @Pattern(regexp = "")
    String email;

    @Max(value = 100)
    int age;

}
