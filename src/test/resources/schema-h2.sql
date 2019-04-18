CREATE TABLE IF NOT EXISTS public.users
(
  id INTEGER SERIAL PRIMARY KEY NOT NULL,
  n_number VARCHAR(60)        NOT NULL UNIQUE,
  create_timestamp TIMESTAMP NOT NULL ,
  lastupdate_timestamp TIMESTAMP NOT NULL,
  full_name VARCHAR(250) DEFAULT NULL NULL,
  email VARCHAR(250) DEFAULT NULL NULL
);

CREATE TABLE IF NOT EXISTS public.worksegments
(
  id  INTEGER SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(60)        NOT NULL UNIQUE,
  create_timestamp TIMESTAMP  ,
  lastupdate_timestamp TIMESTAMP
);

CREATE TABLE IF NOT EXISTS public.timesheets
(
  id  INTEGER SERIAL PRIMARY KEY NOT NULL,
  user_id  INTEGER,
  FOREIGN KEY(user_id) REFERENCES users(id),
  worksegment_id  INTEGER,
  FOREIGN KEY(worksegment_id) REFERENCES worksegments(id),
  week_start_date TIMESTAMP                            NOT NULL,
  week_end_date   TIMESTAMP                            NOT NULL,
  create_timestamp TIMESTAMP NOT NULL ,
  lastupdate_timestamp TIMESTAMP NOT NULL,
  timesheet_status BOOLEAN   NOT NULL
);

CREATE TABLE IF NOT EXISTS public.timesheet_details_all (
  id           INTEGER SERIAL PRIMARY KEY                 NOT NULL,
  timesheet_id         INTEGER,
  FOREIGN KEY (timesheet_id) REFERENCES timesheets (id),
  monday_hours         NUMERIC(4, 2)                      NOT NULL,
  tuesday_hours        NUMERIC(4, 2)                      NOT NULL,
  wednesday_hours      NUMERIC(4, 2)                      NOT NULL,
  thursday_hours       NUMERIC(4, 2)                      NOT NULL,
  friday_hours         NUMERIC(4, 2)                      NOT NULL,
  saturday_hours       NUMERIC(4, 2)                      NOT NULL,
  sunday_hours         NUMERIC(4, 2)                      NOT NULL,
  create_timestamp     TIMESTAMP                          NOT NULL,
  lastupdate_timestamp TIMESTAMP                          NOT NULL
);


CREATE TABLE IF NOT EXISTS public.timesheet_details
(
  id           INTEGER SERIAL PRIMARY KEY         NOT NULL,
  timesheet_id INTEGER,
  FOREIGN KEY (timesheet_id) REFERENCES timesheets (id),
  actual_date  TIMESTAMP                          NOT NULL,
  hours        NUMERIC(4, 2)                      NOT NULL,
  create_timestamp TIMESTAMP NOT NULL ,
  lastupdate_timestamp TIMESTAMP NOT NULL
);