<template>
    <div 
              no-body
              bg-variant="dark"
              text-variant="white"
              class="overflow-hidden card m-2"
              style="height: 100px;"
            >
              <row no-gutters>
                <div class="card-body">
                  <h5 class="card-title">{{post.title}}</h5>
                  <h6 class="card-subtitle mb-2 text-muted">{{post.type}} </h6>
                  <p class="card-text">{{post.description }}</p>
                  <hr />
                </div>
              </col>
            </row>
          </div>
</template>

<script>
export default {
  name: "PostCard",
  props: {
    post: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>
</style>