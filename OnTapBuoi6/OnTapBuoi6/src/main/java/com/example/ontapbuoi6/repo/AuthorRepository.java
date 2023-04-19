package com.example.ontapbuoi6.repo;

import com.example.ontapbuoi6.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author , Integer> {

    @Query("SELECT author FROM Author author WHERE  author.name =: name")
    List<Author> findByName(String name , Pageable pageable);
}
