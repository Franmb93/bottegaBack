package com.example.bottegaBack.services.impl;

import java.util.List;

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
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User findById(long id) {
        return dao.findById(id).orElseThrow(() -> new Error("Couldn't find User " + id));
    }

    @Override
    public User save(User user) {
        return dao.save(user);
    }

    @Override
    public boolean delete(long id) {
        dao.delete(this.findById(id));

        return true;
    }
    
}
