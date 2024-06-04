<template>
  <div class="container">
    <div class="links">
      <a :href="'admin/projects'"> Projects </a>
      <a :href="'admin/posts'"> Posts </a>
    </div>
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
                <button
                  class="btn btn-warning"
                  @click="updateProject(project.id)"
                >
                  Update
                </button>
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
        <div class="row">
          <button class="btn btn-success" @click="addProject">Add</button>
        </div>
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
  name: "AdminView",
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
      projects,
      loading,
      error,
      page,
      nextPage,
      previousPage,
      addProject,
      updateProject,
      deleteProject,
    };
  },
};
</script>

<style scoped>
.container {
  height: 100vh;
}
.links {
  padding-top: 10vh;
}
</style>
