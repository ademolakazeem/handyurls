--DROP TABLE IF EXISTS getUsers cascade;

CREATE TABLE IF NOT EXISTS users(
  id SERIAL PRIMARY KEY NOT NULL,
   name VARCHAR NOT NULL UNIQUE,
   nnumber VARCHAR(10)  NOT NULL UNIQUE,
   created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   last_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP CHECK (created<=last_modified)
);

CREATE TABLE IF NOT EXISTS urls(
 id SERIAL PRIMARY KEY NOT NULL,
 name VARCHAR NOT NULL,
 link VARCHAR NOT NULL,
 terms VARCHAR NOT NULL,
 created_by INTEGER NOT NULL,
 FOREIGN KEY(created_by) REFERENCES users(id),
 created TIMESTAMP DEFAULT CURRENT_TIMESTAMP
 --,
 --last_modified_by VARCHAR,
 --last_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP CHECK (created<=last_modified)
);