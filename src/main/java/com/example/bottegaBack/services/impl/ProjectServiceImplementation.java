package com.example.bottegaBack.services.impl;

import java.util.List;

import com.example.bottegaBack.entities.Project;
import com.example.bottegaBack.repository.IProjectDao;
import com.example.bottegaBack.services.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImplementation implements IProjectService{

    @Autowired
    private IProjectDao dao;

    @Override
    public List<Project> findAll() {
        return dao.findAll();
    }

    @Override
    public Project findById(long id) {
        return dao.findById(id).orElseThrow(() -> new Error("Couldn't find Project " + id));
    }

    @Override
    public Project save(Project project) {
        return dao.save(project);
    }

    @Override
    public boolean delete(long id) {
        dao.delete(this.findById(id));

        return true;
    }
    
}
