import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import NotFoundView from "../views/NotFoundView.vue";
import ProjectsView from "@/views/ProjectsView.vue";
import BlogView from "@/views/BlogView.vue";
import ProjectDetailsView from "@/views/ProjectDetailsView.vue";
import AdminView from "@/views/AdminView.vue";
import AddPost from "@/components/AddPost.vue";
import AddProject from "@/components/AddProject.vue";
import UpdatePost from "@/components/UpdatePost.vue";
import UpdateProject from "@/components/UpdateProject.vue";

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
    path: "/admin",
    name: "admin",
    component: AdminView,
  },
  {
    path: "/admin/project",
    name: "projectAdd",
    component: AddProject,
  },
  {
    path: "/admin/project/:id",
    name: "projectUpdate",
    component: UpdateProject,
  },
  {
    path: "/admin/blog",
    name: "post",
    component: AddPost,
  },
  {
    path: "/admin/post/:id",
    name: "postUpdate",
    component: UpdatePost,
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
