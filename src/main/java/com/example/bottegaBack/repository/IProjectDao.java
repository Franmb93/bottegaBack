package com.example.bottegaBack.repository;

import com.example.bottegaBack.entities.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectDao extends JpaRepository<Project, Long>{
    
}
