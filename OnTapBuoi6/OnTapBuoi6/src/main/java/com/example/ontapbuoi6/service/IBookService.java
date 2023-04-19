package com.example.ontapbuoi6.service;


import com.example.ontapbuoi6.dto.BookDTO;
import com.example.ontapbuoi6.model.Book;

import java.util.List;

public interface IBookService {

    String createNewBook(BookDTO bookDTO);

    Book findAuthorById(int id);

    List<Book> findAllBook();

    Book updateBook(int id , BookDTO bookDTO);
}
