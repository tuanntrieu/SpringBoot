package com.example.ontapbuoi6.service.imp;

import com.example.ontapbuoi6.dto.AuthorDTO;
import com.example.ontapbuoi6.model.Author;
import com.example.ontapbuoi6.repo.AuthorRepository;
import com.example.ontapbuoi6.service.IAuthorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImpAuthorService implements IAuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author creadNewAuthor(AuthorDTO authorDTO) {
        return authorRepository.save(new Author(authorDTO.getName(), authorDTO.getAddress()));
    }

    @Override
    public List<Author> listAuthor(int page , int size) {
        if (page < 0) page = 0;
        return  authorRepository.findAll(PageRequest.of(page , size , Sort.by("name").descending())).getContent();
    }
}
