package com.example.bottegaBack.services;

import java.util.List;

import com.example.bottegaBack.DTO.UserDTO;
import com.example.bottegaBack.entities.User;

public interface IUserService {
    
    public List<UserDTO> findAll();
    public UserDTO findById(String id);
    public UserDTO save(User user);
    public boolean delete(String id);
}
