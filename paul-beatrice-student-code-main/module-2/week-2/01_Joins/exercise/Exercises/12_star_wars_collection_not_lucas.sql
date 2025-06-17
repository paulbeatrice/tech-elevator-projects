-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas, sorted alphabetically.
-- (5 rows)

SELECT movie.title
FROM movie
JOIN collection ON movie.collection_id = collection.collection_id
WHERE collection.collection_id = 10
	AND movie.director_id !=1
	ORDER BY title
;

