<template>
  <div class="container mt-5">
    <h3>Add a New Post</h3>
    <form @submit.prevent="addPost">
      <div class="mb-3">
        <label for="title" class="form-label">Title</label>
        <input
          type="text"
          v-model="post.title"
          class="form-control"
          id="title"
          required
        />
      </div>
      <div class="mb-3">
        <label for="description" class="form-label">Description</label>
        <textarea
          v-model="post.description"
          class="form-control"
          id="description"
          required
        ></textarea>
      </div>
      <div class="mb-3">
        <label for="type" class="form-label">Type</label>
        <input
          type="text"
          v-model="post.type"
          class="form-control"
          id="type"
          required
        />
      </div>
      <div class="mb-3">
        <label for="reference" class="form-label">Reference</label>
        <input
          type="text"
          v-model="post.reference"
          class="form-control"
          id="reference"
          required
        />
      </div>
      <button type="submit" class="btn btn-primary">Add Post</button>
    </form>
  </div>
  <div>
    <h3>All Posts</h3>
    <div class="container">
      <div v-if="loading">Loading...</div>
      <div v-else-if="error">{{ error }}</div>
      <div v-else>
        <table class="table">
          <thead>
            <tr>
              <th>Title</th>
              <th>Description</th>
              <th>Type</th>
              <th>Reference</th>
              <th>Update</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="post in posts" :key="post.id">
              <td>{{ post.title }}</td>
              <td>{{ post.description }}</td>
              <td>{{ post.type }}</td>
              <td>{{ post.reference }}</td>
              <td>
                <button class="btn btn-warning">Update</button>
              </td>
              <td>
                <button class="btn btn-danger" @click="deletePost(post.id)">
                  Delete
                </button>
              </td>
            </tr>
          </tbody>
        </table>
        <div>
          <button @click="previousPage" :disabled="page === 1">Previous</button>
          <button @click="nextPage">Next</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { ref } from "vue";
import axios from "axios";

export default {
  name: "AddPost",
  setup() {
    const posts = ref([]);
    const loading = ref(true);
    const error = ref(null);
    const page = ref(1);
    const pageSize = ref(5);
    const post = ref({
      title: "",
      description: "",
      type: "",
      reference: "",
    });

    const fetchPosts = async () => {
      loading.value = true;
      try {
        const response = await axios.get("http://localhost:8080/post/", {
          params: {
            page: page.value,
            pageSize: pageSize.value,
          },
        });
        posts.value = response.data;
        loading.value = false;
      } catch (err) {
        error.value = "Failed to fetch projects";
        loading.value = false;
      }
    };

    const nextPage = () => {
      page.value += 1;
      fetchPosts();
    };

    const previousPage = () => {
      if (page.value > 1) {
        page.value -= 1;
        fetchPosts();
      }
    };

    onMounted(() => {
      fetchPosts();
    });

    const addPost = async () => {
      try {
        const response = await axios.post(
          `http://localhost:8080/post/post`,
          post.value
        );
        alert("Post added successfully!");
        post.value = {
          title: "",
          description: "",
          type: "",
          reference: "",
        };
      } catch (err) {
        console.error("Failed to add post", err);
        alert("Failed to add post");
      }
    };
    const deletePost = async (id) => {
      try {
        await axios.delete(`http://localhost:8080/post/${id}`);
        fetchPosts();
      } catch (err) {
        error.value = "Failed to delete post";
      }
    };

    return {
      post,
      addPost,
      posts,
      loading,
      error,
      page,
      nextPage,
      previousPage,
      deletePost,
    };
  },
};
</script>
