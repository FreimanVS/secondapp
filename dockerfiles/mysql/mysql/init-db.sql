DROP SCHEMA IF EXISTS company;
CREATE SCHEMA company;
USE company;
GRANT ALL PRIVILEGES ON company.* TO 'root'@'%' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON company.* TO 'root'@'localhost' IDENTIFIED BY 'pass';

DROP SCHEMA IF EXISTS guessnumber;
CREATE SCHEMA guessnumber;
USE guessnumber;
GRANT ALL PRIVILEGES ON guessnumber.* TO 'root'@'%' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON guessnumber.* TO 'root'@'localhost' IDENTIFIED BY 'pass';

CREATE TABLE guessnumber.guesser (
	id BIGINT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	count TINYINT NOT NULL DEFAULT 0,
	PRIMARY KEY (id),
	CONSTRAINT uniqEmployee UNIQUE (name)
);