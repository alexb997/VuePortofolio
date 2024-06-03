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
</template>

<script>
import { ref } from "vue";
import axios from "axios";
import { useRoute } from "vue-router";

export default {
  name: "AddPost",
  setup() {
    const route = useRoute();
    const projectId = route.params.id;
    const post = ref({
      title: "",
      description: "",
      type: "",
      reference: "",
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

    return {
      post,
      addPost,
    };
  },
};
</script>
