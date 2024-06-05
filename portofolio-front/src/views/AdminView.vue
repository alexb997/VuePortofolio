<template>
  <div class="container">
    <div class="links">
      <a :href="'admin/projects'"> Projects </a>
      <a :href="'admin/posts'"> Posts </a>
    </div>
  </div>
</template>

<script>
export default {
  name: "AdminView",
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
