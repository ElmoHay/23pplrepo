
DROP TABLE IF EXISTS "jose".course;

CREATE TABLE "jose". course (
  id INT PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS "jose".student;
  
CREATE TABLE "jose".student (
  id INT  PRIMARY KEY,
  rut VARCHAR(20) NULL,
  firstname VARCHAR(250) NOT NULL,
  lastname VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  course_id INT NULL,
  FOREIGN KEY (course_id) REFERENCES "jose".course(id)
);