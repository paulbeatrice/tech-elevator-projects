-- database m2_final_project
BEGIN TRANSACTION;

-- *************************************************************************************************
-- Drop all db objects in the proper order
-- *************************************************************************************************
DROP TABLE IF EXISTS users;

-- *************************************************************************************************
-- Create the tables and constraints
-- *************************************************************************************************

--users (name is pluralized because 'user' is a SQL keyword)
CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


-- Stolen directly from m2_final_project.sql
CREATE TABLE agency (
    agency_id SERIAL,
    agency_name varchar(100) NOT NULL,
    address varchar(100) NOT NULL,
    policy varchar(300) NOT NULL,

    CONSTRAINT pk_agency PRIMARY KEY (agency_id)
);

CREATE TABLE pet (
    pet_id SERIAL,
    pet_name varchar(100) NOT NULL,
    adoption_info varchar(300),
    pet_type varchar(50) NOT NULL,
    agency_id int NOT NULL,

    CONSTRAINT pk_pet PRIMARY KEY (pet_id),
    CONSTRAINT fk_pet_agency FOREIGN KEY (agency_id) REFERENCES agency (agency_id),
    CONSTRAINT chk_pet_type CHECK (pet_type IN ('Dog', 'Cat'))
);

CREATE TABLE users_pet (
    user_id int,
    pet_id int,
    accept boolean,
    created_at timestamp,

    CONSTRAINT pk_users_pet PRIMARY KEY (user_id, pet_id), -- compound primary key
    CONSTRAINT fk_users_pet_users FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT fk_users_pet_pet FOREIGN KEY (pet_id) REFERENCES pet (pet_id)
);

COMMIT TRANSACTION;
