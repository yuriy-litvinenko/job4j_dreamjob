CREATE TABLE IF NOT EXISTS city
(
    id   integer PRIMARY KEY,
    name varchar(100)
);
CREATE TABLE IF NOT EXISTS post
(
    id          SERIAL PRIMARY KEY,
    name        varchar(100),
    city_id     integer,
    date_create timestamp
);
CREATE TABLE IF NOT EXISTS candidate
(
    id          SERIAL PRIMARY KEY,
    name        varchar(100),
    city_id     integer,
    date_create timestamp
);
CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    name     varchar(100),
    email    varchar(100) UNIQUE,
    password varchar(100)
);
