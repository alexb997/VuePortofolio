package com.example.backend.repositoryTest;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.backend.models.Post;
import com.example.backend.repository.PostRepository;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;
    
    @Test
    @Order(1)
    @Rollback(value = false)
    public void savePostTest(){

        Post post = Post.builder()
                .title("post1")
                .type("blog")
                .description("complain")
                .reference("5")
                .description("complain")
                .build();

        postRepository.save(post);

        Assertions.assertThat(post.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getPostTest(){

        Post post = postRepository.findById(1L).get();

        Assertions.assertThat(post.getId()).isEqualTo(1L);

    }

    @Test
    @Order(3)
    public void getListOfPostsTest(){

        List<Post> posts = postRepository.findAll();

        Assertions.assertThat(posts.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updatePostTest(){

        Post post = postRepository.findById(1L).get();

        post.setDescription("edited_Description");

        Post updatedPost =  postRepository.save(post);

        Assertions.assertThat(updatedPost.getDescription()).isEqualTo("edited_Description");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deletePostTest(){

        Post post = postRepository.findById(1L).get();

        postRepository.delete(post);

        Post post1 = null;

        Optional<Post> optionalPost = postRepository.findById((long) 2);

        if(optionalPost.isPresent()){
            post1 = optionalPost.get();
        }

        Assertions.assertThat(post1).isNull();
    }

}
