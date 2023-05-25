package com.example.ontapbuoi7.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
    @NotNull(message = "Name is not null")
    private String name;
    private String phoneNumber;

    private int student_id;
}
