<template>
  <div class="projects">
    <h3>All Projects</h3>
    <div class="col">
      <div class="m-3" v-for="index in 4" :key="index" style="height: 300px">
        <router-link :to="`/project/project.id`">
          <b-card
            no-body
            bg-variant="dark"
            text-variant="white"
            class="overflow-hidden project-card"
            style="height: 300px"
          >
            <b-row no-gutters>
              <b-col md="6">
                <b-card-img
                  src="project.imgUrl"
                  alt="project.name"
                  class="rounded-0"
                ></b-card-img>
              </b-col>
              <b-col md="6">
                <b-card-body title="project.name" sub-title="project.status">
                  <hr />
                </b-card-body>
                <div class="container card-underbody">
                  <b-row align-v="end" style="height: 100%">
                    <div class="container">
                      <div class="row p-2">
                        <div class="col">
                          <a href="project.gitUrl" target="_blank" @click.stop
                            ><span class="button-project p-2">GitHub</span>
                          </a>
                        </div>
                      </div>
                    </div>
                  </b-row>
                </div>
              </b-col>
            </b-row>
          </b-card>
        </router-link>
      </div>
    </div>
  </div>
</template>
