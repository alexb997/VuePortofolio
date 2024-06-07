<template>
    <div class="container">
      <h3>All Posts</h3>
      <div class="col">
        <div
          class="m-3"
          v-for="(post,index) in posts"
          :key="index"
          style="height: 300px;"
        >
        <div 
              no-body
              bg-variant="dark"
              text-variant="white"
              class="overflow-hidden card"
              style="height: 300px;"
            >
              <row no-gutters>
                <col md="6">
                  <b-card-img
                    src="post.referenceImgUrl"
                    class="rounded-0"
                  ></b-card-img>
                </col>
                <div class="card-body">
                  <h5 class="card-title">{{post.title}}</h5>
                  <h6 class="card-subtitle mb-2 text-muted">{{post.type}} </h6>
                  <p class="card-text">{{post.description }}</p>
                  <hr />
                  <div class="container card-underbody">
                    <row align-v="end" style="height: 100%;">
                      <div class="container ">
                        <div class="row p-2">
                          <div class="col ">
                            <a
                              :href="`/project/${post.reference}`"
                              class="card-link"
                              ><span class="button-project p-2">Reference</span>
                            </a>
                          </div>
                        </div>
                      </div>
                    </row>
                  </div>
                </div>
              </col>
            </row>
          </div>
        </div>
      </div>
    </div>
  </template>

  
<script>
import axios from "axios";
import { ref, onMounted } from "vue";

export default {
  name: "BlogView",
  setup() {
    const posts = ref([]);
    const loading = ref(true);
    const error = ref(null);
    const page = ref(1);
    const pageSize = ref(5);

    const fetchPosts = async () => {
      loading.value = true;
      try {
        const response = await axios.get("http://localhost:8080/post/", {
          params: {
            page: page.value,
            pageSize: pageSize.value,
          },
        });
        posts.value = response.data;
        loading.value = false;
      } catch (err) {
        error.value = "Failed to fetch projects";
        loading.value = false;
      }
    };

    const nextPage = () => {
      page.value += 1;
      fetchPosts();
    };

    const previousPage = () => {
      if (page.value > 1) {
        page.value -= 1;
        fetchPosts();
      }
    };

    onMounted(() => {
      fetchPosts();
    });

    return {
      posts,
      loading,
      error,
      page,
      nextPage,
      previousPage,
    };
  },
};
</script>

  
  <style scoped>
  .posts {
    min-height: 100vh;
  }
  .container{
    min-height: 100vh;
  }
  
  .bCard {
    color: white;
    background-color: rgba(0, 0, 0, 0.137);
  }
  </style>
  