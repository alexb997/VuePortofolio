<template>
  <div class="container projects">
    <h3>All Projects</h3>
    <div class="row">
      <div class="col-md-4" v-for="index in 4" :key="index">
        <b-card img-top class="bCard m-3" tag="project">
          <b-card-text>
            {{ index }}
          </b-card-text>
        </b-card>
      </div>
    </div>
  </div>
</template>
