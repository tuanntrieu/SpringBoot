package com.example.codebuoi9.repo;

import com.example.codebuoi9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);
}
