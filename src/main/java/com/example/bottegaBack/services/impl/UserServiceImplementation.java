package com.example.bottegaBack.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.bottegaBack.DTO.UserDTO;
import com.example.bottegaBack.entities.User;
import com.example.bottegaBack.repository.IUserDao;
import com.example.bottegaBack.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements IUserService{

    @Autowired
    private IUserDao dao;

    @Override
    public List<UserDTO> findAll() {
        var userList = dao.findAll();
        List<UserDTO> userDtoList = new ArrayList<>();

        userList.stream().forEach(user -> 
            userDtoList.add(new UserDTO(user.getUsername(), user.getPassword(), user.getProjects())));

        return userDtoList;
    }

    @Override
    public UserDTO findById(String id) {
        User userRecovered = extracted(id);

        return new UserDTO(userRecovered.getUsername(), userRecovered.getPassword(), userRecovered.getProjects());
    }

    private User extracted(String id) throws Error {
        return dao.findByUsername(id)
                                    .stream().findFirst().orElseThrow(() -> new Error("Couldn't find User " + id));
    }

    @Override
    public UserDTO save(User user) {
        User userSaved = dao.save(user);
        return new UserDTO(userSaved.getUsername(), userSaved.getPassword(), userSaved.getProjects());
    }

    @Override
    public boolean delete(String id) {
        dao.delete(extracted(id));

        return true;
    }
    
}
