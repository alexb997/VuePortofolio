<template>
  <!--Main Navigation-->
  <header>
    <Sidebar></Sidebar>
  </header>
  <main style="margin-top: 58px">
    <div class="container pt-4">
      <router-view></router-view>
    </div>
  </main>
</template>

//
<script>
import Sidebar from "./components/Sidebar.vue";

export default {
  components: {
    Sidebar,
  },
};
</script>

<style>
@media (min-width: 991.98px) {
  main {
    padding-left: 240px;
  }
}
</style>
