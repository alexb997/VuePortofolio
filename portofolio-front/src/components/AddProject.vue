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
  <div>
    <h3>All Projects</h3>
    <div class="container">
      <div v-if="loading">Loading...</div>
      <div v-else-if="error">{{ error }}</div>
      <div v-else>
        <table class="table">
          <thead>
            <tr>
              <th>Name</th>
              <th>Description</th>
              <th>Image Url</th>
              <th>Git Url</th>
              <th>Status</th>
              <th>Update</th>
              <th>Delete</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="project in projects" :key="project.id">
              <td>{{ project.name }}</td>
              <td>{{ project.description }}</td>
              <td>{{ project.imgUrl }}</td>
              <td>{{ project.gitUrl }}</td>
              <td>{{ project.status }}</td>
              <td>
                <button class="btn btn-warning">Update</button>
              </td>
              <td>
                <button
                  class="btn btn-danger"
                  @click="deleteProject(project.id)"
                >
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
import { ref, onMounted } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

export default {
  name: "AddProject",
  setup() {
    const projects = ref([]);
    const loading = ref(true);
    const error = ref(null);
    const page = ref(1);
    const pageSize = ref(5);
    const router = useRouter();

    const fetchProjects = async () => {
      loading.value = true;
      try {
        const response = await axios.get("http://localhost:8080/project/", {
          params: {
            page: page.value,
            pageSize: pageSize.value,
          },
        });
        projects.value = response.data;
        loading.value = false;
      } catch (err) {
        error.value = "Failed to fetch projects";
        loading.value = false;
      }
    };

    const addProject = async () => {
      try {
        const response = await axios.post(
          "http://localhost:8080/project/post",
          project.value
        );
        alert("Project added successfully!");
        fetchProjects();
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

    const deleteProject = async (id) => {
      try {
        await axios.delete(`http://localhost:8080/project/${id}`);
        fetchProjects();
      } catch (err) {
        error.value = "Failed to delete project";
      }
    };

    const nextPage = () => {
      page.value += 1;
      fetchProjects();
    };

    const previousPage = () => {
      if (page.value > 1) {
        page.value -= 1;
        fetchProjects();
      }
    };

    onMounted(() => {
      fetchProjects();
    });

    return {
      project,
      addProject,
      projects,
      loading,
      error,
      page,
      nextPage,
      previousPage,
      deleteProject,
    };
  },
};
</script>
