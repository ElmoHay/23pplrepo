DROP TABLE IF EXISTS STUDENT;
  
CREATE TABLE STUDENT (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  rut VARCHAR(20) NULL,
  firstname VARCHAR(250) NOT NULL,
  lastname VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);