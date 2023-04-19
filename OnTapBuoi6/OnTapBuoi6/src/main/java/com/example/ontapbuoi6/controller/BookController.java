package com.example.ontapbuoi6.controller;

import com.example.ontapbuoi6.dto.BookDTO;
import com.example.ontapbuoi6.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @PostMapping("/create_book")
    public ResponseEntity<?> createNewBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.createNewBook(bookDTO));
    }

    @GetMapping("/find_by_id/{id}")
    public ResponseEntity<?> getByBookId(@PathVariable("id") int id) {
        return ResponseEntity.ok(bookService.findAuthorById(id));
    }

    @GetMapping("/find_all")
    public ResponseEntity<?> findAllBook() {
        return ResponseEntity.ok(bookService.findAllBook());
    }

    @PutMapping("/update_book/{id}")
    public ResponseEntity<?>updateBook(@PathVariable("id")int id , @RequestBody BookDTO bookDTO){
        return ResponseEntity.ok(bookService.updateBook(id , bookDTO));
    }
}
