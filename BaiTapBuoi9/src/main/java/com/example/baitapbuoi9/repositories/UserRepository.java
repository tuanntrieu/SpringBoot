package com.example.baitapbuoi9.repositories;

import com.example.baitapbuoi9.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByUsername(String username);


    @Query(value = "select * from users where username like '%?1%'",nativeQuery = true)
    User searchUserByName(String username);

//    @Query(value = "update users set fullname= ?2,address=?3, email=?4,birthday=?5, username=?6,password=?7 where id =?1",nativeQuery = true)
//    User updateUserById(int id, String fullname, String address, String email, Date birthday,String username,String password );

}
