package com.example.ontapbuoi6.service;

import com.example.ontapbuoi6.dto.AuthorDTO;
import com.example.ontapbuoi6.model.Author;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAuthorService {
    Author creadNewAuthor(AuthorDTO authorDTO);

    List<Author> listAuthor(int page, int size);
}
