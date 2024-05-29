<script setup>
import { RouterLink } from "vue-router";
</script>

<template>
  <nav id="sidebarMenu" class="collapse d-lg-block sidebar collapse bg-dark">
    <div class="position-sticky">
      <div class="list-group-flush mx-3 mt-4 sidebar-links">
        <RouterLink
          to="/"
          active-class="active"
          class="list-group-item router-link list-group-item-action py-2 px-3 ripple"
        >
          <span>Home</span>
        </RouterLink>
        <RouterLink
          to="/projects"
          active-class="active"
          class="list-group-item router-link list-group-item-action py-2 px-3 ripple"
          ><span>Projects</span></RouterLink
        >
        <RouterLink
          to="/blog"
          active-class="active"
          class="list-group-item router-link list-group-item-action py-2 px-3 ripple"
          ><span>Blog</span></RouterLink
        >
      </div>
    </div>
  </nav>
  <div class="container-fluid fixed-top">
    <button
      data-mdb-button-init
      class="navbar-toggler"
      type="button"
      data-mdb-collapse-init
      data-mdb-target="#sidebarMenu"
      aria-controls="sidebarMenu"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      Toggle
    </button>
  </div>
</template>

<style scoped>
.sidebar {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  padding: 58px 0 0; /* Height of navbar */
  box-shadow: 0 2px 5px 0 rgb(0 0 0 / 5%), 0 2px 10px 0 rgb(0 0 0 / 5%);
  width: 240px;
  z-index: 600;
  color: gray;
}

@media (max-width: 991.98px) {
  .sidebar {
    width: 100%;
  }
}
.sidebar .active {
  border-radius: 5px;
  background-color: rgba(0, 0, 0, 0.2);
}

.sidebar-sticky {
  position: relative;
  top: 0;
  height: calc(100vh - 48px);
  padding-top: 0.5rem;
  overflow-x: hidden;
  overflow-y: auto;
}
</style>
