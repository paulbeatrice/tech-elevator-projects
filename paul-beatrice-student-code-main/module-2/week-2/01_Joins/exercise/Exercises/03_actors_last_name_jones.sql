-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in.
-- Order the results by the actor names (A-Z) and then by movie title (A-Z).
-- (48 rows)

SELECT person.person_name, title
FROM person
JOIN movie_actor ON person.person_id = movie_actor.actor_id
JOIN movie ON movie.movie_id = movie_actor.movie_id
WHERE person_name  LIKE '%Jones'
	AND person_name NOT LIKE '%Zeta-Jones%'
ORDER BY person_name, title
;

