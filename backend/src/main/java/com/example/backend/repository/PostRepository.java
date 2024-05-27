package com.example.backend.repository;

import com.example.backend.models.Post;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    @SuppressWarnings("null")
    Page<Post> findAll(Pageable pageable);
    List<Post> findByProjectId(Long projectId);
    
}