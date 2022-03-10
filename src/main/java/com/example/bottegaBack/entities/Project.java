package com.example.bottegaBack.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Project implements Serializable {
    

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 32, message = "max size of the name is 32 char")
    private String name;

    @NotNull
    @Size(max = 255, message = "max size of the description is 255 char")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
	private User user;	
}
