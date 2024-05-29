import axios from "axios";

const PROJECT_API_URL = "http://localhost:8080/project";

class ProjectDataService {
  retrieveAllProjects(page, pageSize) {
    return axios.get(`${PROJECT_API_URL}/`, {
      params: {
        page: page,
        pageSize: pageSize,
      },
    });
  }

  retrieveProject(id) {
    return axios.get(`${PROJECT_API_URL}/${id}`);
  }

  deleteProject(id) {
    return axios.delete(`${PROJECT_API_URL}/${id}`);
  }

  updateProject(id, project) {
    return axios.put(`${PROJECT_API_URL}/${id}`, project);
  }

  createProject(project) {
    return axios.post(`${PROJECT_API_URL}/post`, project);
  }
}

export default new ProjectDataService();
