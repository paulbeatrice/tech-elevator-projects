-- database m2_final_project
BEGIN TRANSACTION;

-- *************************************************************************************************
-- Drop all db objects in the proper order
-- *************************************************************************************************
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS packages;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS users;

-- *************************************************************************************************
-- Create the tables and constraints
-- *************************************************************************************************

--Create Users Table
CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
);

CREATE TABLE clients (
    client_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NUll,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20) NOT NULL
    reated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE packages (
    package_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

 CREATE TABLE Orders (
    order_id SERIAL PRIMARY KEY,
    client_id INT REFERENCES Clients(client_id) ON DELETE CASCADE,
    package_id INT REFERENCES Packages(package_id) ON DELETE CASCADE,
    status VARCHAR(20) DEFAULT 'new',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );



-- *************************************************************************************************
-- Here is where I implemented the sample data to populate the database tables

 --Sample Data To Load Into Clients
    INSERT INTO Clients (name, email, phone) VALUES
    ('Robert Beatrice', 'bobexample@gmail.com', '859-333-1234'),
    ('JK Beatrice', 'jkbeatriceexample@yahoo.com', '513-267-3333'),
    ('Bridgette Clark', 'bridgetteclarkexample@gmail.com', '240-333-8974'),
    ('Robert Beatrice II', 'robert.beatrice2@yahoo.com', '859-222-2323'),
    ('Eddie Justice', 'astroeddie23@gmail.com', '859-212-3434'),
    ('Stephanie Bechard', 'stephexample@gmail.com', '343-262-3383'),
    ('Billy Jones', 'billyj@gmail.com', '513-222-1111'),
    ('Jay Lim', 'jaylim3@yahoo.com', '630-125-5559'),
    ('Liz Perez', 'lizperezexample@yahoo.com', '699-744-3512'),
    ('Jae Torez', 'jaetorez7@yahoo.com', '853-333-9127');

    --Data For Packages
    INSERT INTO Packages (name, description, price) VALUES
    ('Starter SEO Package',
    'This package is designed for small businesses and includes keyword research, on-page SEO optimization, local SEO setup (i.e, google business listing, yelp, trip advisor, etc.) and also includes basic analytics reporting. It is a perfect fit for businesses looking to establish an online presence in their local market.',
    500.00),
    ('Growth SEO Package',
    'This package offers a comprehensive SEO approach, including competitive keyword research, on and off-page optimization, backlink building, a content optimization plan, and monthly analysis reports with actionable insights into the data.',
    1500.00),
    ('Enterprise SEO Advanced Package',
    'Designed for large companies who want to dominate their competitive industries. This package covers technical SEO audits, site architecture optimization, high-quality backlink acquisitions, a thorough content marketing strategy, international SEO (if applicable), real-time data reporting with an account manager.',
    5000.00),
    ('Creator Visibility Package',
    'This package is designed to increase the online visibility of content creators. It includes optimization for blog posts, Youtube videos, podcast episodes, etc., niche keyword research, metadata optimization, topic trends analysis, and performance reports.',
    700.00),
    ('Social Media SEO Amplifier',
    'Anyone who has an online presence realizes how important social media can be for a business or individual. This package focuses on optimizing social media profiles and content for discoverability. It includes hashtag research, platform-specific SEO (Instagram, Facebook, TikTok, X, etc.) It also links these strategies to help drive traffic to websites and give insights to trending topics, posts, and includes social keywords.',
    500.00);

    INSERT INTO Orders (client_id, package_id, status) VALUES
    (1, 1, 'new'), -- Client 1 ordered Starter SEO Package
    (2, 2, 'completed'), -- Client 2 ordered the Growth SEO Package
    (3, 3, 'pending'), -- Client 3 ordered the Enterprise SEO Advanced Package
    (4, 4, 'new'), -- Client 4 ordered the Creator Visibility Package
    (5, 5, 'new'), -- Client 5 ordered the Social Media SEO Amplifier
    (6, 1, 'completed'), -- Client 6 ordered the Starter SEO Package
    (7, 2, 'canceled'), -- Client 7 ordered the Growth SEO Package but it was canceled later
    (8, 3, 'pending'),
    (9, 4, 'completed'),
    (10, 5, 'new');
-- *************************************************************************************************

-- Users
-- Password for all users is password
INSERT INTO
    users (username, password_hash, role)
VALUES
    ('user', '$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_USER'),
    ('admin','$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_ADMIN');

COMMIT TRANSACTION;
