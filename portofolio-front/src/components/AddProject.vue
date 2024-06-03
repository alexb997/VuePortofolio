<template>
  <div class="container mt-5">
    <h3>Add a New Project</h3>
    <form @submit.prevent="addProject">
      <div class="mb-3">
        <label for="name" class="form-label">Project Name</label>
        <input
          type="text"
          v-model="project.name"
          class="form-control"
          id="name"
          required
        />
      </div>
      <div class="mb-3">
        <label for="description" class="form-label">Description</label>
        <textarea
          v-model="project.description"
          class="form-control"
          id="description"
          required
        ></textarea>
      </div>
      <div class="mb-3">
        <label for="imgUrl" class="form-label">Image URL</label>
        <input
          type="text"
          v-model="project.imgUrl"
          class="form-control"
          id="imgUrl"
          required
        />
      </div>
      <div class="mb-3">
        <label for="status" class="form-label">Status</label>
        <input
          type="text"
          v-model="project.status"
          class="form-control"
          id="status"
          required
        />
      </div>
      <div class="mb-3">
        <label for="gitUrl" class="form-label">Git URL</label>
        <input
          type="text"
          v-model="project.gitUrl"
          class="form-control"
          id="gitUrl"
          required
        />
      </div>
      <button type="submit" class="btn btn-primary">Add Project</button>
    </form>
  </div>
</template>

<script>
import { ref } from "vue";
import axios from "axios";

export default {
  name: "AddProject",
  setup() {
    const project = ref({
      name: "",
      description: "",
      imgUrl: "",
      status: "",
      gitUrl: "",
    });

    const addProject = async () => {
      try {
        const response = await axios.post(
          "http://localhost:8080/project/post",
          project.value
        );
        alert("Project added successfully!");
        project.value = {
          name: "",
          description: "",
          imgUrl: "",
          status: "",
          gitUrl: "",
        };
      } catch (err) {
        console.error("Failed to add project", err);
        alert("Failed to add project");
      }
    };

    return {
      project,
      addProject,
    };
  },
};
</script>
