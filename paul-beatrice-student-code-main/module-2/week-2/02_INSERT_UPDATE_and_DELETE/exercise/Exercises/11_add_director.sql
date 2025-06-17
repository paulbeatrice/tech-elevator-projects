-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet. Write an INSERT query to add yourself to the person
--     table, and an UPDATE query to assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)

INSERT into person (person_name, birthday)
VALUES ('Paul Beatrice', '1997-10-31');

SELECT *
FROM person 
ORDER BY person_name;

UPDATE movie
SET director_id = (SELECT person_id FROM person WHERE person_name = 'Paul Beatrice')
WHERE movie_id = 367220;

