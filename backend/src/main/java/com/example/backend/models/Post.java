package com.example.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String type;
    private String reference;
    private String referenceImgUrl;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id") 
    @JsonBackReference 
    private Project project;  

}
