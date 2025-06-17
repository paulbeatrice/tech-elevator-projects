BEGIN TRANSACTION;

DROP TABLE IF EXISTS song;

CREATE TABLE song (
	song_id serial PRIMARY KEY,
	title varchar(100),
	artist varchar(50),
	release_date date,
	genre varchar(50)
);

INSERT INTO song VALUES (DEFAULT, 'Renegade', 'Styx', '1980-01-01', 'RAWK');
INSERT INTO song VALUES (DEFAULT, 'Mr. Roboto', 'Styx', '1980-01-01', 'RAWK');
INSERT INTO song VALUES (DEFAULT, 'Come Sail Away', 'Styx', '1980-01-01', 'RAWK');

COMMIT;