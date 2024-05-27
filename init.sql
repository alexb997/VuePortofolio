CREATE TABLE project (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  description TEXT,
  imgUrl VARCHAR(255),
  status VARCHAR(255),
  gitUrl VARCHAR(255)
);

CREATE TABLE post (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255),
  description TEXT,
  type VARCHAR(255),
  reference VARCHAR(255),
  project_id BIGINT,
  FOREIGN KEY (project_id) REFERENCES project (id)
);