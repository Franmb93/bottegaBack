package com.example.bottegaBack.controllers;

import java.util.List;

import com.example.bottegaBack.DTO.UserDTO;
import com.example.bottegaBack.entities.User;
import com.example.bottegaBack.services.IUserService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    
    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> list() {
        var users = userService.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> userById(@PathVariable(value = "id") String id){
        UserDTO user = userService.findById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO user){
         User userCreate = new User(user.getUsername(), user.getPassword(), user.getProjects());
         userService.save(userCreate);

        return new ResponseEntity<>(userCreate, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable(value = "id") String id){
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
