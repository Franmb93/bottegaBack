package com.example.bottegaBack.DTO;

import java.util.List;

import com.example.bottegaBack.entities.Project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String username;
    private String password;

    private List<Project> projects;
    
}
