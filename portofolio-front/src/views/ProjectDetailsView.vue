<template>
  <div>
    <div class="container">
      <div class="col infoZone mt-5 mb-4">
        <b-img :src="project.imgUrl" class="pt-4" fluid></b-img>
        <h3>{{ project.name }}</h3>
        <div class="row p-1">
          <label>Name: {{ project.name }}</label>
        </div>
        <div class="row p-1">
          <label>Description :{{ project.description }}</label>
        </div>
        <div class="row p-1">
          <label>ImgUrl :{{ project.imgUrl }}</label>
        </div>
        <div class="row p-1">
          <label>Status :{{ project.imgUrl }}</label>
        </div>
      </div>
      <h3>Related Posts</h3>
      <div class="container p-3" v-if="project.posts && project.posts.length">
        <PostCard
          v-for="(post, index) in project.posts"
          :key="index"
          :post="post"
        >
        </PostCard>
      </div>
    </div>
    <div class="pb-5">
      <h3>Add a post:</h3>
      <a :href="project.id + `/addPost`"
        >Redirect(Adauga trimitere proiect la componenta creeare post)</a
      >
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";
import { useRoute } from "vue-router";
import PostCard from "@/components/PostCard.vue";

export default {
  name: "ProjectDetails",
  components: {
    PostCard,
  },
  setup() {
    const project = ref({});
    const route = useRoute();

    const fetchProject = async () => {
      try {
        const response = await axios.get(
          `http://localhost:8080/project/${route.params.id}`
        );
        project.value = response.data;
      } catch (err) {
        console.error("Failed to fetch project", err);
      }
    };

    onMounted(() => {
      fetchProject();
    });

    return {
      project,
    };
  },
};
</script>
