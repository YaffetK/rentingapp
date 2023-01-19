package com.example.bokningsapp.service;

import com.example.bokningsapp.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {


    ResponseEntity<User> getUser(long id);

    ResponseEntity<List<User>> getAllUsers(); //dubbelchecka denna med Kristoffer
    ResponseEntity<User> saveUser (User user);
    ResponseEntity<User> updateUser(long id, User user);
    String deleteUser (long id);

}
