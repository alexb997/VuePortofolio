<template>
  <div class="container mt-5">
    <h3>Update Project</h3>
    <form @submit.prevent="updateProject">
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
      <button type="submit" class="btn btn-primary">Update Project</button>
    </form>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";
import { useRoute, useRouter } from "vue-router";

export default {
  name: "UpdateProject",
  setup() {
    const project = ref({
      name: "",
      description: "",
      imgUrl: "",
      status: "",
      gitUrl: "",
    });
    const route = useRoute();
    const router = useRouter();
    const projectId = route.params.id;

    const fetchProject = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/project/${projectId}`
        );
        Object.assign(project.value, response.data);
      } catch (err) {
        console.error("Failed to fetch project", err);
      }
    };

    const updateProject = async () => {
      try {
        await axios.put(
          `http://localhost:8080/project/${projectId}`,
          project.value
        );
        alert("Project updated successfully!");
      } catch (err) {
        console.error("Failed to update project", err);
        alert("Failed to update project");
      }
    };

    onMounted(() => {
      fetchProject();
    });

    return {
      project,
      updateProject,
    };
  },
};
</script>
