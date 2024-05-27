package com.example.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.models.Post;
import com.example.backend.models.Project;
import com.example.backend.services.ProjectService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/project")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController
{
    @Autowired
    ProjectService projectsService;

    @GetMapping("/")
    public ResponseEntity<List<Project>> getAllProjects(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int pageSize){
            Pageable pageable = PageRequest.of(page - 1, pageSize); 
            Page<Project> projectsPage = projectsService.getAll(pageable);

            List<Project> projects = projectsPage.getContent();
            if (projects.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project>  getProject(@PathVariable("id") Long id)
    {
        Optional<Project> project = projectsService.getById(id);
        if (!project.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(project.get());
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable("id") Long id){
        projectsService.delete(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Project>  saveProject( @RequestBody Project project){
        return ResponseEntity.ok(projectsService.create(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectsService.update(project));
    }
}
