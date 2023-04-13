package com.example.buoi5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//kho viet bang navtive
@Repository//danh dau tuong tac voi csdl
public interface UserResponsitory extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
    @Query(value = "SELECT * FROM users WHERE" +
            " id =?1 AND username=?2",nativeQuery = true)
//    @Query("SELECT u FROM users u WHERE" +
//            " u.id =?1 AND u.username=?2")
    User findUser(Long id, String username);
}
