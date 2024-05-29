<template>
    <div class="container posts">
      <h3>All Posts</h3>
      <div class="col">
        <div
          class="m-3"
          v-for="index in 5"
          :key="index"
          style="height: 300px;"
        >
        <b-card
              no-body
              bg-variant="dark"
              text-variant="white"
              class="overflow-hidden project-card"
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
                  <h5 class="card-title">post.title</h5>
                  <h6 class="card-subtitle mb-2 text-muted">post.type </h6>
                  <p class="card-text">{post.description }</p>
                  <hr />
                  <div class="container card-underbody">
                    <row align-v="end" style="height: 100%;">
                      <div class="container ">
                        <div class="row p-2">
                          <div class="col ">
                            <a
                              :href="`/project/{post.reference}`"
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
          </b-card>
        </div>
      </div>
    </div>
  </template>
  
  <style>
  .posts {
    min-height: 100vh;
  }
  
  .bCard {
    color: white;
    background-color: rgba(0, 0, 0, 0.137);
  }
  </style>
  