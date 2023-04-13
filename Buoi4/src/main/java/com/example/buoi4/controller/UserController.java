package com.example.buoi4.controller;

import com.example.buoi4.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//tim hieu URL va URI
@RestController
public class UserController {
    static List<User> users=new ArrayList<>();
    static {
        users.add(new User(1,"tuan","123"));
        users.add(new User(2,"tuan1","1234"));
        users.add(new User(3,"tuan2","12345"));
        users.add(new User(4,"tuan3","12356"));

    }
//tim hieu Webrequest
    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestParam(name="username",required = false) String username, @RequestParam("password")String password) {
        User response = null;
        for (User tmp : users) {
            if (tmp.getUsername().equals(username)&& tmp.getPassword().equals(password)) {
                response = tmp;
            }
        }
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/user/{name}")
    public ResponseEntity<?> getUsername(@PathVariable String name){
        User response=null;
        for(User tmp: users){
            if(tmp.getUsername().equals(name)){
                response=tmp;
            }
        }
        return ResponseEntity.ok().body(response);
    }
    //body
    @PostMapping("/body/user")
    public ResponseEntity<?>  createUser(@RequestBody User user){
        return ResponseEntity.ok().body(user);
    }

    //form-data
    @PostMapping("/model/user")
    public ResponseEntity<?>  createUserModel(@ModelAttribute User user){
        return ResponseEntity.ok().body(user);
    }


}
