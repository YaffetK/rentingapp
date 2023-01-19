package com.example.bokningsapp.service;

import com.example.bokningsapp.model.User;
import com.example.bokningsapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<User> getUser(long id) {
        User user = userRepository.getReferenceById(id);

            return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> userList = userRepository.findAll();

            if (!userList.isEmpty()) {
                return new ResponseEntity<>(userList, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }



        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            // Kan jag få ut Error meddelandet på något sätt?

        }
    }

    @Override
    public ResponseEntity<User> saveUser(User user) {
        try{
            User savedUser = userRepository.save(new User(user.getName(),user.getLastName(),user.getEmail()));
            return new ResponseEntity<>(savedUser,HttpStatus.CREATED);

        } catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<User> updateUser(long id , User user) {
        try {
            if (userRepository.existsById(id)) {
                User updatedUser = userRepository.getReferenceById(id);

                updatedUser.setName(user.getName());
                updatedUser.setLastName(user.getLastName());
                updatedUser.setEmail(user.getEmail());

                userRepository.save(updatedUser);

                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }

    @Override
    public String deleteUser(long id) {

        User deletedUser = userRepository.getReferenceById(id);
        try{
            if (userRepository.existsById(id)) {
                userRepository.delete(deletedUser);
                return "User with id:" +id + "Was successfully deleted";
            } else {
                return "There is no current User with id:" + id;
            }
        } catch (Exception e) {
            return "INTERNAL_SERVER_ERROR)";
        }



    }
}
