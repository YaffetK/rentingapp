package com.example.bokningsapp.controller;

import com.example.bokningsapp.model.User;
import com.example.bokningsapp.repository.UserRepository;
import com.example.bokningsapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController( UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers(){

       return userServiceImpl.getAllUsers();
    }


  @GetMapping(value = "user/{id}")
  public ResponseEntity<User>getUser(@PathVariable long id) {

        return userServiceImpl.getUser(id);
     }


    @PostMapping(value = "/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
       return userServiceImpl.saveUser(user);

    }
    @PutMapping(value = "user/{id}")
    public ResponseEntity<User> updateUser (@PathVariable long id, @RequestBody User user) {

        return userServiceImpl.updateUser(id,user);
    }

    @DeleteMapping(value = "user/{id}")
    public String deleteUser(@PathVariable long id) {

        return userServiceImpl.deleteUser(id);
    }

}
