-- 9. The titles of movies directed by James Cameron, sorted alphabetically.
-- (6 rows)

SELECT title
FROM movie
WHERE director_id = ('2710')
ORDER BY title
;

