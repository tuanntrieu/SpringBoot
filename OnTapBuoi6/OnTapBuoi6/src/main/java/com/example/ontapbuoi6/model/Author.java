package com.example.ontapbuoi6.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    @JsonManagedReference
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Book> books;
    @JsonManagedReference
    @OneToOne(mappedBy = "author")
    private Publisher publisher;

    public Author(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
