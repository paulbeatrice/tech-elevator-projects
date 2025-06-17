BEGIN TRANSACTION;

-- Users
INSERT INTO users (username, password_hash, role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username, password_hash, role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username, password_hash, role) VALUES ('user3','user3','ROLE_USER');


-- Dummy Data!
INSERT INTO agency VALUES (DEFAULT, 'Agency-1', '123 Main St', 'of truth');
INSERT INTO agency VALUES (DEFAULT, 'Agency-2', '234 Main St', 'Adopt all, plz');
INSERT INTO agency VALUES (DEFAULT, 'Agency-3', '345 Main St', 'Adopt all, please');

INSERT INTO pet VALUES (DEFAULT, 'Doggo', 'Fussy eater', 'Dog', 1);
INSERT INTO pet VALUES (DEFAULT, 'Cat', 'Fancy Feast Only,', 'Cat', 2);
INSERT INTO pet VALUES (DEFAULT, 'CatDog', 'Eats everything', 'Dog', 2);



COMMIT TRANSACTION;
