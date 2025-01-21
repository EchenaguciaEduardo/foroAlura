CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name varchar(100) not null,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);