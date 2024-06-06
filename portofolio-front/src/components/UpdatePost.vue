<template>
  <div class="container mt-5">
    <h3>Update Post</h3>
    <form @submit.prevent="updatePost">
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
      <button type="submit" class="btn btn-primary">Update Post</button>
    </form>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";
import { useRoute, useRouter } from "vue-router";

export default {
  name: "UpdatePost",
  setup() {
    const post = ref({
      title: "",
      description: "",
      type: "",
      reference: "",
    });
    const route = useRoute();
    const router = useRouter();
    const postId = route.params.id;

    const fetchPost = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/post/${postId}`
        );
        Object.assign(post.value, response.data);
      } catch (err) {
        console.error("Failed to fetch post", err);
      }
    };

    const updatePost = async () => {
      try {
        await axios.put(`http://localhost:8080/post/${postId}`, post.value);
        alert("Post updated successfully!");
      } catch (err) {
        console.error("Failed to update post", err);
        alert("Failed to update post");
      }
    };

    onMounted(() => {
      fetchPost();
    });

    return {
      post,
      updatePost,
    };
  },
};
</script>
