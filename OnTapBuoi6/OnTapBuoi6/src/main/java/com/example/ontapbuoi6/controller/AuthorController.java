package com.example.ontapbuoi6.controller;

import com.example.ontapbuoi6.dto.AuthorDTO;
import com.example.ontapbuoi6.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
public class AuthorController {


    @Autowired
    private IAuthorService authorService;

    @PostMapping("/create_author")
    public ResponseEntity<?> createNewAuthor(@RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok(authorService.creadNewAuthor(authorDTO));
    }

        @GetMapping("/get_all_author")
         public ResponseEntity<?> findAllAuthor(@RequestParam(name = "page", required = false) int page,
                                           @RequestParam(name = "size", required = false, defaultValue = "5") int size) {
        return ResponseEntity.ok(authorService.listAuthor(page, size));
    }
}
