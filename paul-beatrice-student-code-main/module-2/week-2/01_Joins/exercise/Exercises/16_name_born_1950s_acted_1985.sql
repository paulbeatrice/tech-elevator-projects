-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985.
-- Order the results by actor from oldest to youngest.
-- (20 rows)

SELECT DISTINCT person_name, birthday
FROM movie_actor
JOIN person ON movie_actor.actor_id = person.person_id
JOIN movie ON movie_actor.movie_id = movie.movie_id
WHERE birthday BETWEEN '1950-01-01' AND '1959-12-31'
	AND movie.release_date BETWEEN '1985-01-01' AND '1985-12-31'
ORDER BY birthday
	
;

