package com.example.bottegaBack.services;

import java.util.List;

import com.example.bottegaBack.DTO.ProjectDTO;
import com.example.bottegaBack.entities.Project;

public interface IProjectService {
    public List<ProjectDTO> findAll();
    public ProjectDTO findById(long id);
    public ProjectDTO save(Project project);
    public boolean delete(long id);
}
