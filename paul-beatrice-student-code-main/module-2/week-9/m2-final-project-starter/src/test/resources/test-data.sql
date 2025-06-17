BEGIN TRANSACTION;

-- TEST Users
INSERT INTO users (username, password_hash, role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username, password_hash, role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username, password_hash, role) VALUES ('user3','user3','ROLE_USER');

-- TEST Clients
INSERT INTO clients(name, email, phone) VALUES ('Joe Bob Client Example', 'jobbobexample@yahoo.com', '732-222-0202');
INSERT INTO clients(name, email, phone) VALUES ('Alice Smith Client Example', 'alicesmithexample@yahoo.com', '732-333-0303');
INSERT INTO clients(name, email, phone) VALUES ('Tyler Fontaine Client Example', 'tylerfontaineexample@yahoo.com', '732-444-0404');

--TEST Packages
INSERT INTO packages(name, description, price) VALUES ('Basic SEO Test Package', 'Test Package for Basic SEO Package', 7000.00);
INSERT INTO packages(name, description, price) VALUES ('Advanced SEO Test Package', 'Test Package for Advanced SEO Package', 8000.00);

--TEST Orders
INSERT INTO orders (client_id, package_id, status) VALUES (1, 1, 'new' );
INSERT INTO orders (client_id, package_id, status) VALUES (2, 2, 'completed');

COMMIT TRANSACTION;
