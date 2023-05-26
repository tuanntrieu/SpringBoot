package com.example.baitapbuoi9.dto;

import com.example.baitapbuoi9.enums.EnumRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    @Enumerated(value = EnumType.STRING)
    private EnumRole roleName;
}
