BEGIN TRANSACTION;
	DROP TABLE IF EXISTS Review;
	DROP TABLE IF EXISTS Product;
	DROP TABLE IF EXISTS users;

	CREATE TABLE users (
		user_id SERIAL,
		username varchar(50) NOT NULL UNIQUE,
		password_hash varchar(200) NOT NULL,
		role varchar(50) NOT NULL,
		CONSTRAINT PK_user PRIMARY KEY (user_id)
	);



	CREATE TABLE Product (
		id SERIAL PRIMARY KEY,
		name VARCHAR(255) NOT NULL,
		description TEXT NOT NULL
	);

	CREATE TABLE Review (
		id SERIAL PRIMARY KEY,
		product_id INTEGER NOT NULL,
		reviewer VARCHAR(255) NOT NULL,
		title VARCHAR(255) NOT NULL,
		review TEXT NOT NULL,
		rating INTEGER NOT NULL CHECK (rating BETWEEN 1 AND 5),
		favorited BOOLEAN NOT NULL DEFAULT FALSE,
		CONSTRAINT fk_product
		  FOREIGN KEY (product_id)
		  REFERENCES Product (id)
		  ON DELETE CASCADE
	);

COMMIT TRANSACTION;

-- select * from product;
-- select * from review;
