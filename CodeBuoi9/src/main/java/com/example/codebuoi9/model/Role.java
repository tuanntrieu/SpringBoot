package com.example.codebuoi9.model;

import com.example.codebuoi9.enums.EnumRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private EnumRole roleName;


    @JsonIgnore
    @OneToMany(mappedBy = "role" , fetch = FetchType.EAGER)
    private List<User> users;
}
