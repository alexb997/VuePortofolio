// package com.example.backend.controllerTest;
// import static org.assertj.core.api.Assertions.assertThat;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import com.example.backend.controllers.PostController;
// import com.example.backend.models.Post;
// import com.example.backend.services.PostService;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;

// public class PostControllerTest {

//     @Mock
//     private PostService postServiceMock;

//     @InjectMocks
//     private PostController postController;

//     @SuppressWarnings("deprecation")
// @BeforeEach
//     void setUp() {
//         MockitoAnnotations.initMocks(this);
//     }

//     @Test
//     void testGetAllPosts() {
//         List<Post> posts = new ArrayList<>();
//         posts.add(new Post(1L, "Title 1", "Content 1", "test", "test", null));
//         posts.add(new Post(2L, "Title 2", "Content 2","test", "test", null));

//         when(postServiceMock.getAll()).thenReturn(posts);

//         ResponseEntity<List<Post>> response = postController.getAllPosts();

//         assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//         assertThat(response.getBody()).isEqualTo(posts);
//     }

//     @Test
//     void testSavePost() {
//         Post postToSave = new Post(2L, "Title 2", "Content 2","test", "test", null);
//         Post savedPost = new Post(2L, "Title 2", "Content 2","test", "test", null);

//         when(postServiceMock.create(any(Post.class))).thenReturn(savedPost);

//         ResponseEntity<Post> response = postController.savePost(postToSave);

//         assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//         assertThat(response.getBody()).isEqualTo(savedPost);
//     }

//     @Test
//     void testUpdatePost() {
//         Post postToUpdate = new Post(1L, "To update", "Content","test", "test", null);
//         Post updatedPost = new Post(1L, "Updated", "Updated Content","test", "test", null);

//         when(postServiceMock.update(any(Post.class))).thenReturn(updatedPost);

//         ResponseEntity<Post> response = postController.updatePost(postToUpdate);

//         assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//         assertThat(response.getBody()).isEqualTo(updatedPost);
//     }
// }