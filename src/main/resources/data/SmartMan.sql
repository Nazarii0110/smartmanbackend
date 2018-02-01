CREATE SCHEMA IF NOT EXISTS smartman DEFAULT CHARACTER SET utf8;
USE smartman;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id bigint NOT NULL AUTO_INCREMENT,
  surname varchar(45) NOT NULL,
  name varchar(45) NOT NULL,
  middle_name varchar(45) NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



