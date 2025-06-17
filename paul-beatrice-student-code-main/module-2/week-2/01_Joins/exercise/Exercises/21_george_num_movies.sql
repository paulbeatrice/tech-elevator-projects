-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in. Name the count column 'num_of_movies'.
-- Include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order.
-- (59 rows)
-- TIP: This one can be a little tricky. If you're off by one, look closer at each clause of your statement. There's something you can change to get a different result set.

SELECT person.person_name, COUNT(movie_actor.movie_id) AS num_of_movies
FROM person
LEFT JOIN movie_actor ON person.person_id = movie_actor.actor_id
WHERE person.person_name LIKE 'George %'
GROUP BY person.person_id, person.person_name
ORDER BY person.person_name
;