CREATE TABLE post (
                      id SERIAL PRIMARY KEY,
                      name TEXT,
                      city_id integer,
                      date_create timestamp,
);
CREATE TABLE candidate (
                      id SERIAL PRIMARY KEY,
                      name TEXT,
                      date_create timestamp
);
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name TEXT,
                       email TEXT UNIQUE,
                       password TEXT
);
CREATE TABLE city (
                       id integer PRIMARY KEY,
                       name character varchar(255)
);