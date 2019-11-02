DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL UNIQUE,
  pass VARCHAR(250) NOT NULL
);

INSERT INTO user (name, pass) VALUES
  ('danialdo', 'ContraDanialdo'),
  ('admin', 'admin'),
  ('chino', 'bacacay');