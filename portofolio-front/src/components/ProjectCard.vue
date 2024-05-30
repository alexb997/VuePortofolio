<template>
  <div class="card h-100" :title="project.name">
    <div class="card-img" :src="project.imgUrl" alt="Project image"></div>
    <div class="card-text">
      <div class="mb-2">
        <strong>Description:</strong> {{ project.description }}
      </div>
      <div class="mb-2"><strong>Status:</strong> {{ project.status }}</div>
    </div>
  </div>
</template>
