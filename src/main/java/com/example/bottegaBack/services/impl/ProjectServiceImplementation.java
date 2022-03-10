package com.example.bottegaBack.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.bottegaBack.DTO.ProjectDTO;
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
    public List<ProjectDTO> findAll() {
        var projectList = dao.findAll();
        List<ProjectDTO> projectDtoList = new ArrayList<>();
        
        projectList.stream().forEach(project -> 
            projectDtoList.add(new ProjectDTO(project.getName(), project.getDescription(), project.getUser()))
        );

        return projectDtoList;
    }

    @Override
    public ProjectDTO findById(long id) {
        Project projectRecovered = dao.findById(id).orElseThrow(() -> new Error("Couldn't find Project " + id));

        return new ProjectDTO(projectRecovered.getName(), projectRecovered.getDescription(), projectRecovered.getUser());
    }

    @Override
    public ProjectDTO save(Project project) {
        Project savedProject = dao.save(project);

        return new ProjectDTO(savedProject.getName(), savedProject.getDescription(), savedProject.getUser());
    }

    @Override
    public boolean delete(long id) {
        dao.delete(dao.findById(id).orElseThrow(() -> new Error("Couldn't find Project " + id)));

        return true;
    }
    
}
