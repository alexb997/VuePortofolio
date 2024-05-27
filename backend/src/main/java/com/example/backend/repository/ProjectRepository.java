package com.example.backend.repository;

import com.example.backend.models.Project;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    @SuppressWarnings("null")
    Page<Project> findAll(Pageable pageable);
    @Query("SELECT p FROM Project p LEFT JOIN FETCH p.posts WHERE p.id = :id")
    Optional<Project> findByIdWithPosts(@Param("id") Long id);
}