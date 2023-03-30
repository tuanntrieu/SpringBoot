package com.example.baitapbuoi3.service;

import com.example.baitapbuoi3.model.User;

import java.util.List;

public interface UserService {
    List<User> getUser();
    void addUser(User user);
}
