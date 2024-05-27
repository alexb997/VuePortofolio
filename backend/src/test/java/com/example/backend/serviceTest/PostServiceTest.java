// package com.example.backend.serviceTest;
// import static org.assertj.core.api.Assertions.assertThat;
// import static org.mockito.Mockito.when;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.ArgumentMatchers.anyLong;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import com.example.backend.models.Post;
// import com.example.backend.models.Project;
// import com.example.backend.repository.PostRepository;
// import com.example.backend.services.PostService;
// import com.example.backend.services.ProjectService;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// public class PostServiceTest {

//     @Mock
//     private PostRepository postRepositoryMock;

//     @Mock
//     private ProjectService projectServiceMock;

//     @InjectMocks
//     private PostService postService;

//     @SuppressWarnings("deprecation")
//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.initMocks(this);
//     }

//     @Test
//     void testGetAll() {
//         List<Post> posts = new ArrayList<>();
//         posts.add(new Post(1L, "Title 1", "Content 1", "test", "test", null));
//         posts.add(new Post(2L, "Title 2", "Content 2","test", "test", null));

//         when(postRepositoryMock.findAll()).thenReturn(posts);

//         List<Post> result = postService.getAll();

//         assertThat(result).isEqualTo(posts);
//     }
// };