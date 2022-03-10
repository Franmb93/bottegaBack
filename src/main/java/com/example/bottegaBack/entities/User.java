package com.example.bottegaBack.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    

	@Id
    @NotNull
	@NotEmpty(message = "Username cannot be empty")
	@Size(min = 4, max = 16, message = "Username must have a length of 4-16 characters")
	private String username;

    @Size(min = 6, message = "Password must have more than 6 characters")
	@NotNull
	@NotEmpty(message = "Password cannot be empty")
	private String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Project> projects;
}
