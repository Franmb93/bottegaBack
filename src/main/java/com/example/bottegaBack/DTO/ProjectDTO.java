package com.example.bottegaBack.DTO;

import com.example.bottegaBack.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProjectDTO {
    
    private Long id;
    private String name;
    private String description;
    private User user;

    public ProjectDTO(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
    }
}
