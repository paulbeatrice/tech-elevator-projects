-- 11. The titles of the movies in the "Star Wars Collection" ordered by release date, most recent first.
-- (9 rows)

SELECT movie.title
FROM movie
JOIN collection ON movie.collection_id = collection.collection_id
WHERE collection.collection_id = 10
ORDER BY movie.release_date DESC
;


