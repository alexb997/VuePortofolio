<template>
  <div>
    <div class="container">
      <div class="col infoZone mt-5 mb-4">
        <b-img :src="this.imgUrl" class="pt-4" fluid></b-img>
        <h3>{{ this.name }}</h3>
        <div class="row p-1">
          <label>Name: {{ this.name }}</label>
        </div>
        <div class="row p-1">
          <label>Description :{{ this.description }}</label>
        </div>
        <div class="row p-1">
          <label>ImgUrl :{{ this.imgUrl }}</label>
        </div>
        <div class="row p-1">
          <label>Status :{{ this.imgUrl }}</label>
        </div>
      </div>
      <h3>Related Posts</h3>
      <div class="container p-3" v-if="posts && posts.length">
        <b-col>
          <b-card
            class="m-3 bCard"
            v-for="post in posts"
            v-bind:key="post.id"
            :title="post.title"
            :sub-title="post.type"
          >
            <b-card-text>
              {{ post.description }}
            </b-card-text>
          </b-card>
        </b-col>
      </div>
    </div>
    <div class="pb-5">
      <h3>Add a post:</h3>
      <a :href="this.id + `/addPost`"
        >Redirect(Adauga trimitere proiect la componenta creeare post)</a
      >
    </div>
  </div>
</template>

<script>

</script>
