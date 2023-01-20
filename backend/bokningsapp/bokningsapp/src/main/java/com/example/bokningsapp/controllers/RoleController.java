package com.example.bokningsapp.controllers;

import com.example.bokningsapp.models.Role;
import com.example.bokningsapp.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {


    private final RoleRepo roleRepository;

    @Autowired
    public RoleController(RoleRepo roleRepository) {
        this.roleRepository= roleRepository;
    }

    @GetMapping(value = "/roles")
    public ResponseEntity<List<Role>> roleList() {

           List<Role> roleList = roleRepository.findAll();
           try {
               if (!roleList.isEmpty()){
                   return new ResponseEntity<>(roleList, HttpStatus.OK);
               }
               else{
                   return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
               }
           } catch (Exception e) {
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

           }
    }

}
