-- 7. The genres of movies that Christopher Lloyd has appeared in, sorted alphabetically.
-- (8 rows) Hint: DISTINCT will prevent duplicate values in your query results.

SELECT DISTINCT genre.genre_name
FROM movie_actor
JOIN movie ON movie_actor.movie_id = movie.movie_id
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre.genre_id = genre.genre_id
WHERE movie_actor.actor_id = ('1062')
ORDER BY genre.genre_name
;







