-- 4. The titles and taglines of all the movies that are in the Fantasy genre.
-- Order the results by title (A-Z).
-- (81 rows)

SELECT title, tagline
FROM movie
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
WHERE genre_id = ('14')
ORDER BY title
;