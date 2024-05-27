package com.example.backend.services;

import com.example.backend.models.Project;
import com.example.backend.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Page<Project> getAll(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    public Optional<Project> getById(Long id)
    {
        return projectRepository.findByIdWithPosts(id);
    }

    public Project create(Project project)
    {
        return projectRepository.save(project);
    }

    public Project update(Project project)
    {
        
        Optional<Project> optionalOldProject = projectRepository.findById(project.getId());
    
        if (optionalOldProject.isPresent()) {
            Project oldProject = optionalOldProject.get();
            oldProject = Project.builder()
                .id(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .imgUrl(project.getImgUrl())
                .status(project.getStatus())
                .gitUrl(project.getGitUrl())
                .build();
            return projectRepository.save(oldProject);
        }else{
            return new Project();
        }
    }

    public Long delete(Long id)
    {
        projectRepository.deleteById(id);
        return id;
    }

}