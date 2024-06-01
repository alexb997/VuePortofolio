<template>
  <div>
    <h3>All Projects</h3>

    <div v-if="loading">Loading...</div>
    <div v-else-if="error">{{ error }}</div>
    <div v-else class="col">
      <project-card
        v-for="(project, index) in projects"
        :key="index"
        :project="project"
      ></project-card>
    </div>

    <div>
      <button @click="previousPage" :disabled="page === 1">Previous</button>
      <button @click="nextPage">Next</button>
    </div>
  </div>
</template>

<script>
import ProjectCard from "@/components/ProjectCard.vue";
import axios from "axios";
import { ref, onMounted } from "vue";

export default {
  name: "ProjectsView",
  components: {
    ProjectCard,
  },
  setup() {
    const projects = ref([]);
    const loading = ref(true);
    const error = ref(null);
    const page = ref(1);
    const pageSize = ref(5);

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
    };
  },
};
</script>
