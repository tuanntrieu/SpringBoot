package com.example.ontapbuoi6.service.imp;

import com.example.ontapbuoi6.dto.BookDTO;
import com.example.ontapbuoi6.model.Author;
import com.example.ontapbuoi6.model.Book;
import com.example.ontapbuoi6.repo.AuthorRepository;
import com.example.ontapbuoi6.repo.BookRepository;
import com.example.ontapbuoi6.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImpBookService implements IBookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    @Override
    public String createNewBook(BookDTO bookDTO) {
        Optional<Author> author = authorRepository.findById(bookDTO.getAuthor_id());
        if (author.isPresent()) {
            bookRepository.save(new Book(bookDTO.getNameBook(), bookDTO.getDetail(), author.get()));
            return "Create new author success";
        } else {
            return String.format("Create new author failed because author with id :%s not found!" , bookDTO.getAuthor_id());
        }
    }

    @Override
    public Book findAuthorById(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateBook(int id, BookDTO bookDTO) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            Optional<Author> author = authorRepository.findById(bookDTO.getAuthor_id());
            if (author.isPresent()) {
                book.get().setAuthor(author.get());
            } else {
                book.get().setAuthor(book.get().getAuthor());
            }
            book.get().setNameBook(bookDTO.getNameBook());
            book.get().setDetail(bookDTO.getDetail());
            bookRepository.save(book.get());
            return book.get();
        }
        return null;
    }
}
