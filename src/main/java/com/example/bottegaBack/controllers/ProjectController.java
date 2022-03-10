package com.example.bottegaBack.controllers;

import java.util.List;

import com.example.bottegaBack.DTO.ProjectDTO;
import com.example.bottegaBack.entities.Project;
import com.example.bottegaBack.services.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProjectController {
    
    @Autowired
    private IProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> list(){
        var projects = projectService.findAll();

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> projectById(@PathVariable(value = "id") long id){
        ProjectDTO project = projectService.findById(id);

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody ProjectDTO project){
         Project projectCreate = new Project(project.getName(), project.getDescription(), project.getUser());
            
         projectService.save(projectCreate);

        return new ResponseEntity<>(projectCreate, HttpStatus.CREATED);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Project> delete(@PathVariable(value = "id") long id){
        projectService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
