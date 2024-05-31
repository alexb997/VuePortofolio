<script>
export default {
  name: "ProjectCard",
  props: {
    project: {
      type: Object,
      required: true,
    },
  },
  methods: {
    redirectToDetails() {
      this.$router.push({
        name: "project",
        params: { id: this.project.id },
      });
    },
  },
};
</script>

<template>
  <div cols="12" md="6" lg="4" class="col mb-3">
    <div :title="project.name" class="card text-white bg-secondary">
      <img
        class="card-img-top card-img"
        :src="project.imgUrl"
        alt="Project image"
      />
      <div class="card-text">
        <div class="mb-2">
          <strong>Description:</strong> {{ project.description }}
        </div>
        <div class="mb-2"><strong>Status:</strong> {{ project.status }}</div>
      </div>
      <button @click="redirectToDetails" class="btn btn-dark button-project">
        View Details
      </button>
    </div>
  </div>
</template>

<style scoped>
.card-img {
  object-fit: cover;
  overflow: hidden;
  height: 14rem;
}
</style>
