package com.example.baitapbuoi3.service;

import com.example.baitapbuoi3.model.Store;
import com.example.baitapbuoi3.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService {
    static List<User> list = Store.getList();

    @Override
    public List<User> getUser() {
        return list;
    }

    @Override
    public void addUser(User user) {
        list.add(user);
    }
}
