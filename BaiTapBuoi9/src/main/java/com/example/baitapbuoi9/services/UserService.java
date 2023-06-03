package com.example.baitapbuoi9.services;

import com.example.baitapbuoi9.dto.UserDTO;
import com.example.baitapbuoi9.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    User createNewUser(UserDTO userDTO);

    User getUserByID(int id);

    User editUserById(int id,UserDTO userDTO);

    void deleteUserById(int id);

    List<User> getAllUser(int page,int size);

    List<User> searchUserByName(String name);
}
