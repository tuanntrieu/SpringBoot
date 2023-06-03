package com.example.baitapbuoi9.repositories;

import com.example.baitapbuoi9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);


    @Query(value = "select * from users where fullname like %?1%", nativeQuery = true)
    List<User> searchUserByName(String fullname);

}
