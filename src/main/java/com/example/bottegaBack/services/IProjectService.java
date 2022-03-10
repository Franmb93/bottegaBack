package com.example.bottegaBack.services;

import java.util.List;

import com.example.bottegaBack.entities.Project;

public interface IProjectService {
    public List<Project> findAll();
    public Project findById(long id);
    public Project save(Project Project);
    public boolean delete(long id);
}
