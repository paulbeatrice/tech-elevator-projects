SELECT * -- movie.title, person.person_name 
FROM person 
INNER JOIN movie_actor ON movie_actor.actor_id = person.person_id
INNER JOIN movie ON movie.movie_id = movie_actor.movie_id
WHERE movie.movie_id = 11
;


SELECT movie.title, person.person_name 
FROM movie
INNER JOIN person ON  person.person_id = movie.director_id
WHERE movie.movie_id = 11
;


SELECT movie.title, collection.collection_name
FROM movie FULL OUTER JOIN collection ON movie.collection_id = collection.collection_id
--   left               right
;



-- ONLY movies that are part of collections
SELECT movie.title, collection.collection_name
FROM movie INNER JOIN collection ON movie.collection_id = collection.collection_id
;

-- ONLY movies that are NOT part of collections
SELECT movie.title, collection.collection_name
FROM movie LEFT JOIN collection ON movie.collection_id = collection.collection_id
WHERE collection.collection_id IS NULL
;

-- ONLY collections that have no movies
SELECT movie.title, collection.collection_name
FROM movie RIGHT JOIN collection ON movie.collection_id = collection.collection_id
WHERE movie.movie_id IS NULL
;

-- All movies and all collections, regardless of connection
SELECT movie.title, collection.collection_name
FROM movie FULL OUTER JOIN collection ON movie.collection_id = collection.collection_id
;

-- All unmatched (movies without collections PLUS collections without movies)
SELECT movie.title, collection.collection_name
FROM movie FULL OUTER JOIN collection ON movie.collection_id = collection.collection_id
WHERE movie.movie_id IS NULL OR collection.collection_id IS NULL
;











