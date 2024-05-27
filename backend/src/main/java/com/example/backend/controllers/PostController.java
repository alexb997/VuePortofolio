package com.example.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.backend.models.Post;
import com.example.backend.services.PostService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/post")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController
{
    @Autowired
    PostService postsService;

    @Autowired
    PostService postService;
    
    @GetMapping("/")
    public ResponseEntity<List<Post>> getAllPosts(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int pageSize){
            
            Pageable pageable = PageRequest.of(page - 1, pageSize); 
            Page<Post> postsPage = postsService.getAll(pageable);

            List<Post> posts = postsPage.getContent();
            if (posts.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

        return ResponseEntity.ok(posts);
    }

    // @GetMapping("/reference/{id}")
    // public ResponseEntity<List<Post>> getAllPostsbyProject(@PathVariable("id") Long id)
    // {
    //     return postsService.getAllByProject(id);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Post>  getPosts(@PathVariable("id") Long id)
    {
        Optional<Post> post = postService.getById(id);
        if (!post.isPresent()) {
            log.error("Id " + id + " is not existed");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(post.get());
    }

    @PutMapping("/{postId}/assign/{projectId}")
    public ResponseEntity<Post> assignPostToProject(
            @PathVariable Long postId,
            @PathVariable Long projectId) {
        
        Post updatedPost = postService.assignPostToProject(postId, projectId);

        if (updatedPost != null) {
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable("id") Long id){
        postsService.delete(id);
    }

    @PostMapping("/post")
    public ResponseEntity<Post>  savePost( @RequestBody Post post){
        return ResponseEntity.ok(postsService.create(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        return ResponseEntity.ok(postsService.update(post));
    }
}
