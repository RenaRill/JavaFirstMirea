CREATE TABLE IF NOT EXISTS patients (
    id SERIAL NOT NULL PRIMARY KEY,
    firstName VARCHAR,
    lastName VARCHAR
);

CREATE TABLE IF NOT EXISTS doctors (
    id SERIAL NOT NULL PRIMARY KEY,
    firstName VARCHAR,
    lastName VARCHAR,
    position VARCHAR
);

create sequence patients_sequence start 1 increment 1
create sequence doctors_sequence start 1 increment 1
