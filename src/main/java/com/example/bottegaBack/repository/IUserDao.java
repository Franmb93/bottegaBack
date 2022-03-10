package com.example.bottegaBack.repository;

import java.util.List;

import com.example.bottegaBack.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<User, Long> {
    
   List<User> findByUsername(String username);
}
