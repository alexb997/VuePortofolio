<template>
  <div class="container">
    <div class="links">
      <a :href="'admin/project'"> Projects </a>
      <a :href="'admin/blog'"> Posts </a>
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
