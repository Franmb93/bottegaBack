package com.example.bottegaBack.services;

import java.util.List;

import com.example.bottegaBack.entities.User;

public interface IUserService {
    
    public List<User> findAll();
    public User findById(long id);
    public User save(User user);
    public boolean delete(long id);
}
