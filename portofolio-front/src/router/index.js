import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import NotFoundView from "../views/NotFoundView.vue";
import ProjectsView from "@/views/ProjectsView.vue";
import BlogView from "@/views/BlogView.vue";
import ProjectDetailsView from "@/views/ProjectDetailsView.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/projects",
    name: "projects",
    component: ProjectsView,
  },
  {
    path: "/project/:id",
    name: "project",
    component: ProjectDetailsView,
  },
  {
    path: "/blog",
    name: "blog",
    component: BlogView,
  },
  {
    path: "/404",
    name: "notFound",
    component: NotFoundView,
  },
  {
    path: "/:catchall(.*)*",
    redirect: "/404",
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
